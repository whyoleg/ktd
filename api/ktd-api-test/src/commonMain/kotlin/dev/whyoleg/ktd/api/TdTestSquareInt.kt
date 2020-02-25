package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the squared received number
 * This is an offline method
 * Can be called before authorization
 *
 * @property x Number to square
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testSquareInt")
data class TdTestSquareInt(
    @SerialName("x")
    val x: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdTestInt> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTestSquareInt {
        return copy(extra = extra.copy(id = id))
    }
}
