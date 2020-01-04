package dev.whyoleg.ktd.cli.diff.data

import dev.whyoleg.ktd.cli.tl.*

data class TlTypeDiff(
    val old: String,
    val new: String
)

data class TlAdditionListDiff(
    val added: List<TlAddition>?,
    val removed: List<TlAddition>?
)
