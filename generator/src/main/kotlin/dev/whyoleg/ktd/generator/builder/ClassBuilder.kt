package dev.whyoleg.ktd.generator.builder

import dev.whyoleg.ktd.generator.tl.*

fun StringBuilder.buildClass(data: TlData, metadata: TlSchemeMetadata) {
    val withDefault: Boolean = data.type.toLowerCase() in metadata.typesWithDefaultsProperties
    val isNullable: Boolean = data.type.toLowerCase() in metadata.typesWithNullableProperties

    val declaration = when (data) {
        is TlAbstract -> "abstract class "
        is TlClass    -> "class "
    }
    val propertiesDescriptions =
        if (data.metadata.properties.isEmpty()) emptyList() else listOf("") + data.metadata.properties.flatMap(TlProperty::descriptionLines)
    val descriptions = data.metadata.descriptions + data.metadata.additions.strings() + propertiesDescriptions


    buildDescription(descriptions)
    buildAnnotations(data.metadata.additions)
    append(declaration).append(data.type.capitalize())
    buildParameters(data.metadata.properties.map { it.toVal(withDefault, isNullable) })
    append(" : ").append(data.parentType.capitalize()).append("()")

    if (data is TlClass) {
        append(spaceToken)
        withCurlyBrackets {
            buildConstructorField(data.crc)
        }
    } else append("\n")
}

fun StringBuilder.buildConstructorField(crc: Int) {
    append("override val constructor: Int get() = ").append(crc)
}
