package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the received string
 * This is an offline method
 * Can be called before authorization
 *
 * @property x String to return
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testCallString")
data class TdTestCallString(
    @SerialName("x")
    val x: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdTestString> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTestCallString {
        return copy(extra = extra.copy(id = id))
    }
}
