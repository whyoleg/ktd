package dev.whyoleg.ktd.cli.diff.data

import dev.whyoleg.ktd.cli.tl.*

data class TlPropertyDiff(
    val name: String,
    val type: TlTypeDiff?,
    val descriptionList: List<StringDiff>?,
    val additionList: TlAdditionListDiff?
)

data class TlPropertyListDiff(
    val added: List<TlProperty>?,
    val removed: List<TlProperty>?,
    val changed: List<TlPropertyDiff>?
)
