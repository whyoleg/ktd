package dev.whyoleg.ktd.cli.diff.data

import dev.whyoleg.ktd.cli.tl.*

data class TlFunctionDiff(
    val type: String,
    val returnType: TlTypeDiff?,
    val metadata: TlMetadataDiff?
)

data class TlFunctionListDiff(
    val added: List<TlFunction>?,
    val removed: List<TlFunction>?,
    val changed: List<TlFunctionDiff>?
)
