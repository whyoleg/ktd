package dev.whyoleg.ktd.cli.diff.data

import dev.whyoleg.ktd.cli.tl.*

data class TlSealedDiff(
    val type: String,
    val metadata: TlMetadataDiff?
)

data class TlSealedListDiff(
    val added: List<TlSealed>?,
    val removed: List<TlSealed>?,
    val changed: List<TlSealedDiff>?
)
