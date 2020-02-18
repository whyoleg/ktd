package dev.whyoleg.ktd.cli.diff.builder

import dev.whyoleg.ktd.cli.builder.*
import dev.whyoleg.ktd.cli.diff.data.*
import dev.whyoleg.ktd.cli.tl.*

private fun sealed(sealed: TlSealed): String = buildString {
    append(sealed.type)
    withIndent {
        metadata(sealed.metadata)
    }
}

private fun change(sealed: TlSealedDiff): String = buildString {
    append(sealed.type)
    withIndent {
        sealed.metadata?.let(this::metadataDiff)
    }
}

fun StringBuilder.sealedListDiff(sealedList: TlSealedListDiff) {
    append("\nSealed classes:")
    sealedList.removed?.joinSubtractions(this, TlSealed::type)
    sealedList.added?.joinAdditions(this, ::sealed)
    sealedList.changed?.joinWithIndent(this, ::change)
}
