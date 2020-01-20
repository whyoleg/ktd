package dev.whyoleg.ktd.cli.api.builder

import dev.whyoleg.ktd.cli.builder.*
import dev.whyoleg.ktd.cli.tl.*

fun StringBuilder.buildClass(data: TlData, metadata: TlDataMetadata) {
    val declaration = when (data) {
        is TlAbstract -> "abstract class "
        is TlClass    -> "class "
    }

    buildDescription(data.descriptionsWithProperties())
    buildAnnotations(data.metadata.additions)
    append(declaration).append(data.type.capitalize())
    buildParameters(data.metadata.properties.map { it.toVal(metadata) })
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

fun TlData.descriptions(): List<String> = metadata.descriptions + metadata.additions.strings()

fun TlData.descriptionsWithProperties(): List<String> =
    descriptions() + (when (metadata.properties.isEmpty()) {
        true  -> emptyList()
        false -> listOf("") + metadata.properties.flatMap(TlProperty::descriptionLines)
    })
