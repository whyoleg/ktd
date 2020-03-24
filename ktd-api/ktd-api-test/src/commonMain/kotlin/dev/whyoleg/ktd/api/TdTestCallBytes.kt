package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the received bytes
 * This is an offline method
 * Can be called before authorization
 *
 * @property x Bytes to return
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testCallBytes")
data class TdTestCallBytes(
    @SerialName("x")
    val x: ByteArray = byteArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdTestBytes> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTestCallBytes {
        return copy(extra = extra.copy(id = id))
    }
}
