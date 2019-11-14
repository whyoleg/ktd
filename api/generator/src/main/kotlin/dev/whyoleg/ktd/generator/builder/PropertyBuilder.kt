package dev.whyoleg.ktd.generator.builder

import dev.whyoleg.ktd.generator.tl.*

fun StringBuilder.buildParameters(parameters: List<String>, addEmptyBrackets: Boolean = false) {
    if (parameters.isNotEmpty()) withRoundBrackets {
        parameters.joinTo(this, ",\n")
    } else if (addEmptyBrackets) append("()")
}

fun TlProperty.toVal(metadata: TlDataMetadata): String = toParameter(metadata, "val ")

fun TlProperty.toParameter(metadata: TlDataMetadata, prefix: String = ""): String {
    val (withDefault) = metadata
    val propName = name.snakeToCamel()
    val defaultValue = if (withDefault) " = ${type.default}" else emptyToken
    val default = if (type is TlRefType) {
        if (additions.any { it is TlAddition.Nullable }) questionToken + defaultValue
        else emptyToken
    } else defaultValue
    return "${inlineAnnotations()}$prefix$propName: ${type.kotlinType}$default"
}

fun TlProperty.descriptionLines(): List<String> {
    val link = "$addressToken${name.snakeToCamel()}$spaceToken$dashToken$spaceToken"
    val spaces = (1..link.length).joinToString("") { " " }
    return listOf(link + descriptions.first()) + (descriptions.drop(1) + additions.strings()).map { "$spaces$it" }
}


fun TlProperty.inlineAnnotations(): String =
    additions
        .filterIsInstance<TlAddition.Annotation>()
        .takeIf(List<*>::isNotEmpty)
        ?.map(TlAddition.Annotation::annotation)
        ?.distinct()
        ?.sorted()
        ?.joinToString(spaceToken + addressToken, addressToken, spaceToken)
        ?: ""
