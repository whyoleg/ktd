package dev.whyoleg.ktd.generator.api.tl

data class TlProperty(
    val name: String,
    val type: TlType,
    val descriptions: List<String>,
    val additions: List<TlAddition>
)

