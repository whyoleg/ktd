package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the received vector of numbers
 * This is an offline method
 * Can be called before authorization
 *
 * @property x Vector of numbers to return
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testCallVectorInt")
data class TdTestCallVectorInt(
    @SerialName("x")
    val x: IntArray = intArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdTestVectorInt> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTestCallVectorInt {
        return copy(extra = extra.copy(id = id))
    }
}
