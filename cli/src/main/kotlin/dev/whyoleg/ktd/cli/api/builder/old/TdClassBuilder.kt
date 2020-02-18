package dev.whyoleg.ktd.cli.api.builder.old

import com.squareup.kotlinpoet.*
import dev.whyoleg.ktd.cli.builder.*
import dev.whyoleg.ktd.cli.tl.*

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

fun tdDataType(
    data: TlData,
    type: TdDataType,
    packageName: String = pcg,
    old: Boolean = false,
    overrideName: String? = null,
    block: TypeSpec.Builder.() -> Unit
): TypeSpec {
    val extraNeeded = type == TdDataType.Response || type == TdDataType.Request || type == TdDataType.SyncRequest
    val isObject = data.metadata.properties.isEmpty() && !extraNeeded
    val className = if (old) tdApiClass.nestedClass(data.type) else {
        ClassName(
            packageName, overrideName ?: when (data) {
                is TlSealedChild -> data.type.substringAfter(data.parentType)
                else             -> "Td${data.type}"
            }
        )
    }
    println(className)
    val spec = when {
        isObject -> TypeSpec.objectBuilder(className)
        else     -> TypeSpec.classBuilder(className).addModifiers(KModifier.DATA)
    }
    spec.addAnnotation(serializableAnnotation)
        .addAnnotation(serialName(data.type.decapitalize()))
        .dataKdoc(data, extraNeeded)
        .apply(block)
        .apply {
            if (type == TdDataType.Request || type == TdDataType.SyncRequest) {
                addFunction(
                    FunSpec.builder("withRequestId")
                        .addModifiers(KModifier.OVERRIDE)
                        .addAnnotation(suppress("OverridingDeprecatedMember"))
                        .addParameter("id", ClassName("kotlin", "Long"))
                        .returns(className)
                        .addCode(CodeBlock.of("return·copy(extra·=·extra.copy(id·=·id))\n"))
                        .build()
                )
            }
        }
    return when {
        isObject -> spec
        else     -> spec.constructor(data, extraNeeded, old)
    }.build()
}

fun TypeSpec.Builder.setParents(
    data: TlData,
    typedScheme: TlTypedScheme,
    old: Boolean = false,
    parentType: String? = null
): TypeSpec.Builder = apply {
    val parent = parentType ?: data.parentType
    when (data.type(typedScheme)) {
        TdDataType.Object      -> {
            if (parent != null) superclass(ClassName.bestGuess(if (old) parent else "Td$parent"))
            else {
                if (old) superclass(ClassName.bestGuess("Object"))
                addSuperinterface(tdObjectClass)
            }
        }
        TdDataType.Response    -> {
            if (parent != null) superclass(ClassName.bestGuess(if (old) parent else "Td$parent"))
            else {
                if (old) superclass(ClassName.bestGuess("Object"))
                addSuperinterface(tdResponseClass)
            }
        }
        TdDataType.Request     -> {
            if (old) superclass(ClassName.bestGuess("Function"))
            val type = typedScheme.requestTypes.getValue(data.type)
            addSuperinterface(tdRequestParameterized(if (old) type else "Td$type"))
        }
        TdDataType.SyncRequest -> {
            if (old) superclass(ClassName.bestGuess("Function"))
            val type = typedScheme.requestTypes.getValue(data.type)
            addSuperinterface(tdSyncRequestParameterized(if (old) type else "Td$type"))
        }
    }
}
