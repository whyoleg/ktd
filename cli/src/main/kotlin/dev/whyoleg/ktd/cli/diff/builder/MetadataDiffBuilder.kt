package dev.whyoleg.ktd.cli.diff.builder

import dev.whyoleg.ktd.cli.*
import dev.whyoleg.ktd.cli.diff.data.*
import dev.whyoleg.ktd.cli.tl.*

fun StringBuilder.metadataDiff(metadata: TlMetadataDiff) {
    metadata.descriptionList?.let(this::descriptionDiff)
    metadata.additionList?.let(this::additionListDiff)
    metadata.propertyList?.let(this::propertyListDiff)
}

fun StringBuilder.metadata(metadata: TlMetadata) {
    metadata.descriptions.takeIfIsNotEmpty()?.let {
        append("\nDescription:")
        it.joinWithIndent(this)
    }
    metadata.additions.takeIfIsNotEmpty()?.let {
        append("\nAdditions:")
        it.joinWithIndent(this)
    }
    metadata.properties.takeIfIsNotEmpty()?.let {
        append("\nProperties:")
        it.joinWithIndent(this, ::property)
    }
}
