package dev.whyoleg.ktd.cli.diff.data

import dev.whyoleg.ktd.cli.tl.*

data class TlObjectDiff(
    val type: String,
    val parentType: TlTypeDiff?,
    val metadata: TlMetadataDiff?
)

data class TlObjectListDiff(
    val added: List<TlObject>?,
    val removed: List<TlObject>?,
    val changed: List<TlObjectDiff>?
)
