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
val tdUpdateClass = ClassName(pcg, "TdUpdate")
val tdObjectClass = ClassName(pcg, "TdObject")
val tdRequestClass = ClassName(pcg, "TdRequest")
val tdSyncRequestClass = ClassName(pcg, "TdSyncRequest")
fun tdRequestParameterized(t: String) = tdRequestClass.parameterizedBy(ClassName("", t))
fun tdSyncRequestParameterized(t: String) = tdSyncRequestClass.parameterizedBy(ClassName("", t))

val extraProperty =
    PropertySpec.builder("extra", ClassName(pcg, "TdExtra"))
        .initializer("extra")
        .addModifiers(KModifier.OVERRIDE)
        .addAnnotation(serialName("@extra"))
        .build()
val extraParameter =
    ParameterSpec.builder("extra", ClassName(pcg, "TdExtra"))
        .defaultValue("TdExtra.EMPTY")
        .build()

fun tdConstructor(extraNeeded: Boolean, block: FunSpec.Builder.() -> Unit): FunSpec = FunSpec.constructorBuilder()
    .apply(block)
    .apply { if (extraNeeded) addParameter(extraParameter) }
    .build()

fun TypeSpec.Builder.constructor(data: TlData, extraNeeded: Boolean): TypeSpec.Builder = apply {
    primaryConstructor(tdConstructor(extraNeeded) {
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

fun TypeSpec.Builder.dataKdoc(data: TlData, extraNeeded: Boolean): TypeSpec.Builder = apply {
    val classDescription = data.metadata.descriptions + data.metadata.additions.strings()
    val propertiesDescription = data.metadata.properties.flatMap {
        val link = "@property ${it.name.snakeToCamel()} "
        val spaces = " ".repeat(link.length)
        val firstLine = link + it.descriptions.first()
        val otherLines = (it.descriptions.drop(1) + it.additions.strings()).map(spaces::plus)
        listOf(firstLine) + otherLines
    } + when (extraNeeded) {
        true  -> listOf("@property extra Extra data shared between request and response")
        false -> emptyList()
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

fun tdDataType(data: TlData, type: TdType, block: TypeSpec.Builder.() -> Unit): TypeSpec {
    val extraNeeded = type == TdType.Response || type == TdType.Request || type == TdType.SyncRequest
    val isObject = data.metadata.properties.isEmpty() && !extraNeeded
    val className = tdApiClass.nestedClass(data.type)
    val defaultSpec = when {
        isObject -> TypeSpec.objectBuilder(className)
        else     -> TypeSpec.classBuilder(className).addModifiers(KModifier.DATA)
    }
    val typeSpec =
        defaultSpec.addAnnotation(serializableAnnotation)
            .addAnnotation(serialName(data.type.decapitalize()))
            .dataKdoc(data, extraNeeded)
            .apply(block)
            .apply {
                data.metadata.additions.filterIsInstance<TlAddition.Annotation>()
                    .map { ClassName(pcg, it.annotation) }
                    .forEach(::addAnnotation)
                if (type == TdType.Request || type == TdType.SyncRequest) {
                    addFunction(
                        FunSpec.builder("withRequestId")
                            .addModifiers(KModifier.OVERRIDE)
                            .addParameter("id", ClassName("kotlin", "Long"))
                            .returns(ClassName("", data.type))
                            .addCode(CodeBlock.of("return·copy(extra·=·extra.copy(id·=·id))\n"))
                            .build()
                    )
                }
            }
    return when {
        isObject -> typeSpec
        else     -> typeSpec.constructor(data, extraNeeded).apply { if (extraNeeded) addProperty(extraProperty) }
    }.build()
}

fun TlType.className(nullable: Boolean): TypeName = when (this) {
    is TlRefType       -> ClassName(kotlinType.takeIf { it == "String" }?.let { "kotlin" } ?: "", kotlinType).copy(nullable = nullable)
    is TlPrimitiveType -> ClassName("kotlin", kotlinType)
    is TlArrayType     -> when (type) { //TODO use lists
        is TlPrimitiveType -> ClassName("kotlin", kotlinType)
        else               -> ClassName("kotlin", "Array").parameterizedBy(type.className(false))
    }
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

fun TypeSpec.Builder.setParents(
    data: TlData,
    responseTypes: Set<String>,
    requestsTypes: Map<String, String>
): TypeSpec.Builder = apply {
    val parent = data.parentType
    val type = when {
        data.type in requestsTypes.keys                       -> when {
            TlAddition.Sync in data.metadata.additions -> TdType.SyncRequest
            else                                       -> TdType.Request
        }
        data.type in responseTypes || parent in responseTypes -> TdType.Response
        data.type.startsWith("Update")                        -> TdType.Update
        else                                                  -> TdType.Object
    }
    when (type) {
        TdType.Object      -> {
            if (parent != null) superclass(ClassName.bestGuess(parent))
            else {
                superclass(ClassName.bestGuess("Object"))
                addSuperinterface(tdObjectClass)
            }
        }
        TdType.Response    -> {
            if (parent != null) superclass(ClassName.bestGuess(parent))
            else {
                superclass(ClassName.bestGuess("Object"))
                addSuperinterface(tdResponseClass)
            }
        }
        TdType.Request     -> {
            superclass(ClassName.bestGuess("Function"))
            addSuperinterface(tdRequestParameterized(requestsTypes.getValue(data.type)))
        }
        TdType.SyncRequest -> {
            superclass(ClassName.bestGuess("Function"))
            addSuperinterface(tdSyncRequestParameterized(requestsTypes.getValue(data.type)))
        }
        TdType.Update      -> {
            superclass(ClassName.bestGuess("Object"))
            addSuperinterface(tdUpdateClass)
        }
    }
}

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

    val sealedTypes = list.filterIsInstance<TlAbstract>().map(TlAbstract::type)
    val sealedResponses = sealedTypes.associateWith { t ->
        list.filter { it.parentType == t }
    }
    //    val allSealedResponses = sealedResponses.values.flatten().map(TlData::type)

    val requestsBlock =
        CodeBlock.builder()
            .beginControlFlow("polymorphic<TdApiRequest>")

    val responseBlock =
        CodeBlock.builder()
            .beginControlFlow("polymorphic<TdApiResponse>")

    fun responseBlock(name: String) =
        CodeBlock.builder()
            .beginControlFlow("polymorphic(TdApiResponse::class, $name::class)")

    val updateBlock =
        responseBlock("Update")

    val allResponseBlock =
        CodeBlock.builder()


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
        .filter { it.type !in existed }
        //        .filter { !allSealedResgjgponses.contains(it.type) }
        //        .take(10)
        .forEach { data ->
            val parent = data.parentType
            val type = when {
                data.type.startsWith("Update")                        -> TdType.Update
                data.type in requestsTypes.keys                       -> when {
                    TlAddition.Sync in data.metadata.additions -> TdType.SyncRequest
                    else                                       -> TdType.Request
                }
                data.type in responseTypes || parent in responseTypes -> TdType.Response
                else                                                  -> TdType.Object
            }
            //            println("[$type]${data.type}: $parent")
            val spec = if (data is TlAbstract) {
                val sealedClassName = tdApiClass.nestedClass(data.type)
                TypeSpec.classBuilder(sealedClassName)
                    .addModifiers(KModifier.ABSTRACT) //TODO use sealed
                    .addAnnotation(serializableAnnotation)
                    .dataKdoc(data, false)
                    .setParents(data, responseTypes, requestsTypes)
                    .build()
            } else tdDataType(data, type) {
                setParents(data, responseTypes, requestsTypes)
            }
            tdApiSpec.addType(spec)


            when (type) {
                TdType.Request, TdType.SyncRequest -> {
                    requestsBlock.addStatement("addSubclass(${data.type}.serializer())")
                }
                TdType.Response                    -> {
                    if (data !is TlAbstract && parent == null) {
                        responseBlock.addStatement("addSubclass(${data.type}.serializer())")
                    } else if (data is TlAbstract) {
                        allResponseBlock.add(
                            responseBlock(data.type).apply {
                                sealedResponses.getValue(data.type).forEach {
                                    addStatement("addSubclass(${it.type}.serializer())")
                                }
                            }.endControlFlow().build()
                        )
                    }
                }
                TdType.Update                      -> {
                    updateBlock.addStatement("addSubclass(${data.type}.serializer())")
                }
            }
        }

    val builderSpec =
        PropertySpec.builder("TdApiV150", ClassName("dev.whyoleg.ktd.api.internal", "StaticTdApi"))
            .addAnnotation(AnnotationSpec.builder(ClassName("kotlin", "Suppress")).addMember("\"DEPRECATION_ERROR\"").build())
            .initializer(
                CodeBlock.builder()
                    .beginControlFlow("InternalTdApi(\"1.5.0\")")
                    .add(requestsBlock.endControlFlow().build())
                    .add(responseBlock.endControlFlow().build())
                    .add(updateBlock.endControlFlow().build())
                    .add(allResponseBlock.build())
                    .endControlFlow()
                    .build()
            )


    FileSpec.builder("dev.whyoleg.ktd.api", "TdApiV150")
        .addProperty(builderSpec.build())
        //        .addImport("dev.whyoleg.ktd.api.TdApi.*")
        .indent("    ")
        .build()
        .writeTo(File("ktd-api/src/commonMain/kotlin"))
    if (false)
        FileSpec.builder("dev.whyoleg.ktd.api", "TdApi")
            .addAnnotation(
                AnnotationSpec.builder(ClassName("kotlin", "UseExperimental"))
                    .addMember("TdBotsOnly::class")
                    .addMember("TdTestingOnly::class")
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
            .writeTo(File("ktd-api/src/commonMain/kotlin"))
    //        .writeTo(System.out)
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
