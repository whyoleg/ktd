package dev.whyoleg.ktd.cli.api.tl

data class TlMetadata(
    val descriptions: List<String>,
    val additions: List<TlAddition>,
    val properties: List<TlProperty>
)
