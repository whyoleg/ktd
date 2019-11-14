package dev.whyoleg.ktd.generator.tl

data class TlMetadata(
    val descriptions: List<String>,
    val additions: List<TlAddition>,
    val properties: List<TlProperty>
)
