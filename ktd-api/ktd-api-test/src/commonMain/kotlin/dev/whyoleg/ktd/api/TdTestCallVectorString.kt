package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the received vector of strings
 * This is an offline method
 * Can be called before authorization
 *
 * @property x Vector of strings to return
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testCallVectorString")
data class TdTestCallVectorString(
    @SerialName("x")
    val x: List<String> = emptyList(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdTestVectorString> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTestCallVectorString {
        return copy(extra = extra.copy(id = id))
    }
}
