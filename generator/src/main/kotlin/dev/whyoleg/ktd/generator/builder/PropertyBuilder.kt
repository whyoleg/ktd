package dev.whyoleg.ktd.generator.builder

import dev.whyoleg.ktd.generator.tl.*

fun StringBuilder.buildParameters(parameters: List<String>) {
    if (parameters.isNotEmpty()) withRoundBrackets {
        parameters.joinTo(this, ",\n")
    }
}

fun TlProperty.toVal(withDefault: Boolean, isNullable: Boolean): String {
    val propName = name.snakeToCamel()

    val nullableToken = if (type is TlRefType && (isNullable || withDefault)) questionToken else emptyToken
    val default = if (withDefault) " = ${type.default}" else emptyToken
    return "${inlineAnnotations()}val $propName: ${type.kotlinType}$nullableToken$default"
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
