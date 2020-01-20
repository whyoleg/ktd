package dev.whyoleg.ktd.cli.diff.data

import dev.whyoleg.ktd.cli.tl.*

data class TlAbstractDiff(
    val type: String,
    val metadata: TlMetadataDiff?
)

data class TlAbstractListDiff(
    val added: List<TlAbstract>?,
    val removed: List<TlAbstract>?,
    val changed: List<TlAbstractDiff>?
)
