package dev.whyoleg.ktd.cli.diff.builder

import dev.whyoleg.ktd.cli.builder.*
import dev.whyoleg.ktd.cli.diff.data.*
import dev.whyoleg.ktd.cli.tl.*

private fun abstract(abstract: TlAbstract): String = buildString {
    append(abstract.type)
    withIndent {
        metadata(abstract.metadata)
    }
}

private fun change(abstract: TlAbstractDiff): String = buildString {
    append(abstract.type)
    withIndent {
        abstract.metadata?.let(this::metadataDiff)
    }
}

fun StringBuilder.abstractListDiff(abstractList: TlAbstractListDiff) {
    append("\nAbstract classes:")
    abstractList.removed?.joinSubtractions(this, TlAbstract::type)
    abstractList.added?.joinAdditions(this, ::abstract)
    abstractList.changed?.joinWithIndent(this, ::change)
}
