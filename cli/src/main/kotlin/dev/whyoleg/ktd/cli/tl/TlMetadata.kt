package dev.whyoleg.ktd.cli.tl

data class TlMetadata(
    val descriptions: List<String>,
    val additions: List<TlAddition>,
    val properties: List<TlProperty>
)
