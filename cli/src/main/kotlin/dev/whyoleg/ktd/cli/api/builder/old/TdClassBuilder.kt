package dev.whyoleg.ktd.cli.api.builder.old

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import dev.whyoleg.ktd.cli.builder.*
import dev.whyoleg.ktd.cli.tl.*
import java.io.*

enum class TdType {
    Object,
    Response,
    Request,
    SyncRequest,
    Update
}

val pcg = "dev.whyoleg.ktd.api"

val serializableAnnotation = ClassName("kotlinx.serialization", "Serializable")
val serialNameAnnotation = ClassName("kotlinx.serialization", "SerialName")
fun serialName(string: String): AnnotationSpec = AnnotationSpec.builder(serialNameAnnotation).addMember("%S", string).build()


val tdApiClass = ClassName(pcg, "TdApi")

val tdResponseClass = ClassName(pcg, "TdResponse")
val tdObjectClass = ClassName(pcg, "TdObject")
val tdRequestClass = ClassName(pcg, "TdRequest")
val tdSyncRequestClass = ClassName(pcg, "TdSyncRequest")
fun tdRequestParameterized(t: String) = tdRequestClass.parameterizedBy(ClassName("", t))
fun tdSyncRequestParameterized(t: String) = tdSyncRequestClass.parameterizedBy(ClassName("", t))

val extraProperty =
    PropertySpec.builder("extra", ClassName(pcg, "TdExtra"))
        .initializer("extra")
        .addAnnotation(serialName("@extra"))
        .build()
val extraParameter =
    ParameterSpec.builder("extra", ClassName(pcg, "TdExtra"))
        .defaultValue("TdExtra.EMPTY")
        .build()

fun tdConstructor(block: FunSpec.Builder.() -> Unit): FunSpec = FunSpec.constructorBuilder()
    .apply(block)
    .addParameter(extraParameter)
    .build()

fun TypeSpec.Builder.constructor(data: TlData, type: TdType): TypeSpec.Builder = apply {
    primaryConstructor(tdConstructor {
        parameters += data.metadata.properties.map {
            it.parameter(
                it.additions.any { it is TlAddition.Nullable } || data is TlFunction,
                data is TlFunction
            )
        }
    })
    propertySpecs += data.metadata.properties.map {
        it.property(it.additions.any { it is TlAddition.Nullable } || data is TlFunction)
    }
}

fun TypeSpec.Builder.dataKdoc(data: TlData, type: TdType): TypeSpec.Builder = apply {
    val classDescription = data.metadata.descriptions + data.metadata.additions.strings()
    val propertiesDescription = data.metadata.properties.flatMap {
        val link = "@property ${it.name.snakeToCamel()} "
        val spaces = " ".repeat(link.length)
        val firstLine = link + it.descriptions.first()
        val otherLines = (it.descriptions.drop(1) + it.additions.strings()).map(spaces::plus)
        listOf(firstLine) + otherLines
    } + when (type) {
        TdType.Response, TdType.Request -> listOf("@property extra Extra data shared between request and response")
        else                            -> emptyList()
    }

    val lines = classDescription + when {
        propertiesDescription.isEmpty() -> emptyList()
        else                            -> listOf("") + propertiesDescription
    }
    lines.forEachIndexed { index, line ->
        addKdoc(line.replace(" ", "·"))
        if (lines.size != index) addKdoc("\n")
    }
}

fun tdDataClass(data: TlData, type: TdType, block: TypeSpec.Builder.() -> Unit): TypeSpec =
    TypeSpec.classBuilder(tdApiClass.nestedClass(data.type))
        .addModifiers(KModifier.DATA)
        .addAnnotation(serializableAnnotation)
        .addAnnotation(serialName(data.type.decapitalize()))
        .constructor(data, type)
        .dataKdoc(data, type)
        .apply(block)
        .apply { if (type == TdType.Response || type == TdType.Request) addProperty(extraProperty) }
        .apply {
            data.metadata.additions.filterIsInstance<TlAddition.Annotation>()
                .map { ClassName(pcg, it.annotation) }
                .forEach(::addAnnotation)
        }
        .build()

fun TlType.className(nullable: Boolean): TypeName = when (this) {
    is TlPrimitiveType -> ClassName("kotlin", kotlinType)
    is TlRefType       -> ClassName(kotlinType.takeIf { it == "String" }?.let { "kotlin" } ?: "", kotlinType).copy(nullable = nullable)
    is TlArrayType     -> ClassName("kotlin", "Array").parameterizedBy(type.className(false)) //TODO use lists
}

fun TlProperty.parameter(nullable: Boolean, default: Boolean): ParameterSpec =
    ParameterSpec.builder(name.snakeToCamel(), type.className(nullable))
        .apply { if (default) defaultValue(type.default) }
        .build()

fun TlProperty.property(nullable: Boolean): PropertySpec =
    PropertySpec.builder(name.snakeToCamel(), type.className(nullable))
        .initializer(name.snakeToCamel())
        .addAnnotation(serialName(name))
        .apply {
            additions.filterIsInstance<TlAddition.Annotation>()
                .map { ClassName(pcg, it.annotation) }
                .forEach(::addAnnotation)
        }
        .build()

fun nestedTypes(map: Map<String, TlData>, types: Set<String>): Set<String> = types.flatMap {
    val data = map.getValue(it)
    val sealed = if (data is TlAbstract) map.values.filter { it.parentType == data.type }.map { it.type } else emptyList()
    sealed + data.metadata.properties
        .map(TlProperty::type)
        .filterIsInstance<TlRefType>()
        .map(TlRefType::kotlinType)
        .filter { it != "String" }
}.toSet()

fun collectNestedTypes(map: Map<String, TlData>, inputTypes: Set<String>): Set<String> {
    val allTypes = inputTypes.toMutableSet()
    var nested = nestedTypes(map, inputTypes)
    while (nested.isNotEmpty()) {
        allTypes += nested
        nested = nestedTypes(map, nested)
    }
    return allTypes
}

val existed = listOf("Ok", "Error", "Close", "Destroy", "LogOut")

fun main() {
    val list = File("td/td/generate/scheme/td_api.tl").readBytes().parseScheme().data
    val map = list.associateBy(TlData::type)

    val requests = list.filterIsInstance<TlFunction>()
    val responseTypes = requests.map(TlFunction::returnType).toSet()
    val requestsTypes = requests.associate { it.type to it.returnType }

    val updates = list.filterIsInstance<TlClass>().filter { it.type.startsWith("Update") }
    val sealed = list.filterIsInstance<TlAbstract>()
    val objects =
        list.filterIsInstance<TlClass>().filter { it.parentType == "Object" }.map(TlClass::type) - responseTypes - sealed.map { it.type }

    val nestedTypes = collectNestedTypes(map, responseTypes)
    val nestedTypes2 = collectNestedTypes(map, requests.map(TlFunction::type).toSet())

    val sealedAn = sealed.flatMap { s ->
        val an = list.filter { it.parentType == s.type }
        an
    }.map { it.type }.toSet()

    println("Stats:")
    println("All:       ${list.size}")
    println("Sealed:    ${sealed.size}")
    println("SealedAn:  ${sealedAn.size}")
    println("Objects:   ${objects.size}")
    println("Updates:   ${updates.size}")
    println("Requests:  ${requests.size}")
    println("Responses: ${responseTypes.size}")
    println("NestedReq: ${nestedTypes.size}")
    println("NestedRes: ${nestedTypes2.size}")

    //    val sealedTypes = list.filterIsInstance<TlAbstract>().map(TlAbstract::type)
    //    val sealedResponses = sealedTypes.associateWith { t ->
    //        list.filter { it.parentType == t }
    //    }
    //    val allSealedResponses = sealedResponses.values.flatten().map(TlData::type)

    val tdApiSpec = TypeSpec.classBuilder(tdApiClass)
        .addTypes(
            listOf(
                TypeSpec.classBuilder("Object")
                    .addSuperinterface(tdObjectClass)
                    .addModifiers(KModifier.ABSTRACT)
                    .build(),
                TypeSpec.classBuilder("Function")
                    .addModifiers(KModifier.ABSTRACT)
                    .superclass(ClassName.bestGuess("Object"))
                    .build()
            )
        )
    list
        //        .filter { it.type !in existed }
        //        .filter { !allSealedResgjgponses.contains(it.type) }
        //        .take(10)
        .forEach { data ->
            val type = when {
                data.type in requestsTypes.keys -> when {
                    TlAddition.Sync in data.metadata.additions -> TdType.SyncRequest
                    else                                       -> TdType.Request
                }
                data.type in responseTypes      -> TdType.Response
                data.type.startsWith("Update")  -> TdType.Update
                else                            -> TdType.Object
            }
            //            println(data)
            val spec = if (data is TlAbstract) {
                val sealedClassName = tdApiClass.nestedClass(data.type)
                TypeSpec.classBuilder(sealedClassName)
                    .addModifiers(KModifier.ABSTRACT) //TODO use sealed
                    .superclass(ClassName.bestGuess("Object"))
                    .dataKdoc(data, type)
                    .apply {
                        if (type == TdType.Response) addSuperinterface(tdResponseClass)
                    }
                    .build()
            } else tdDataClass(data, type) {
                val parent = data.parentType
                if (parent != null) superclass(ClassName.bestGuess(parent))
                when (type) {
                    TdType.Object      -> if (parent == null) {
                        superclass(ClassName.bestGuess("Object"))
                        addSuperinterface(tdObjectClass)
                    }
                    TdType.Response    -> addSuperinterface(tdResponseClass)
                    TdType.Request     -> {
                        superclass(ClassName.bestGuess("Function"))
                        addSuperinterface(tdRequestParameterized(requestsTypes.getValue(data.type)))
                    }
                    TdType.SyncRequest -> {
                        superclass(ClassName.bestGuess("Function"))
                        addSuperinterface(tdSyncRequestParameterized(requestsTypes.getValue(data.type)))
                    }
                    TdType.Update      -> Unit
                }
            }
            tdApiSpec.addType(spec)
        }
    FileSpec.builder("dev.whyoleg.ktd.api", "TdApi")
        .addAnnotation(
            AnnotationSpec.builder(ClassName("kotlin", "UseExperimental"))
                .addMember("BotsOnly::class")
                .addMember("TestingOnly::class")
                .build()
        )
        .addAnnotation(
            AnnotationSpec.builder(ClassName("kotlin", "Suppress"))
                .addMember("\"unused\"")
                .build()
        )
        .indent("    ")
        .apply {
            listOf("Object", "Function", "Update", "Error").forEach {
                addTypeAlias(TypeAliasSpec.builder("Telegram$it", ClassName(pcg, "TdApi.$it")).build())
            }
        }
        .addType(tdApiSpec.build())
        .build()
        .writeTo(System.out)
}

//Sealed
//val spec = if (data is TlAbstract) {
//                val sealedClasses = sealedResponses.getValue(data.type)
//                val sealedClassName = tdApiClass.nestedClass(data.type)
//                TypeSpec.classBuilder(sealedClassName)
//                    .addModifiers(KModifier.SEALED).apply {
//                        sealedClasses.forEach { sealedData ->
//                            addType(tdDataClass(sealedData) {
//                                constructor(sealedData.metadata)
//                                superclass(sealedClassName)
//                            })
//                        }
//                        when (data.type) {
//                            in responseTypes -> addSuperinterface(tdResponseClass)
//                            in requestsTypes -> addSuperinterface(tdRequestParameterized(requestsTypes.getValue(data.type)))
//                            else             -> addSuperinterface(tdObjectClass)
//                        }
//                    }.build()
//            }
