package dev.whyoleg.ktd.cli.api.builder.old

import com.squareup.kotlinpoet.*
import dev.whyoleg.ktd.cli.builder.*
import dev.whyoleg.ktd.cli.tl.*

val pcg = "dev.whyoleg.ktd.api"
val existed = listOf("Ok", "Error", "Close", "Destroy", "LogOut")

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
    val extraNeeded =
        type == TdType.Response || type == TdType.Request || type == TdType.SyncRequest || type == TdType.Update // TODO remove
    val isObject = data.metadata.properties.isEmpty() && !extraNeeded
    val className = tdApiClass.nestedClass(data.type)
    val spec = when {
        isObject -> TypeSpec.objectBuilder(className)
        else     -> TypeSpec.classBuilder(className).addModifiers(KModifier.DATA)
    }
    spec.addAnnotation(serializableAnnotation)
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
        isObject -> spec
        else     -> spec.constructor(data, extraNeeded).apply { if (extraNeeded) addProperty(extraProperty) }
    }.build()
}

fun TypeSpec.Builder.setParents(
    data: TlData,
    responseTypes: Set<String>,
    requestsTypes: Map<String, String>
): TypeSpec.Builder = apply {
    val parent = data.parentType
    when (data.type(responseTypes, requestsTypes)) {
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
            addSuperinterface(tdResponseClass)
        }
    }
}
