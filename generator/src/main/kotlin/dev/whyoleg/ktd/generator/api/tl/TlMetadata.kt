package dev.whyoleg.ktd.generator.api.tl

data class TlMetadata(
    val descriptions: List<String>,
    val additions: List<TlAddition>,
    val properties: List<TlProperty>
)
