package dev.whyoleg.ktd.generator.api.tl

data class RawTlData(val type: RawTlDataType, val list: List<String>, val expression: String)

enum class RawTlDataType { Object, Function }
