package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the received vector of objects containing a number
 * This is an offline method
 * Can be called before authorization
 *
 * @property x Vector of objects to return
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testCallVectorIntObject")
data class TdTestCallVectorIntObject(
    @SerialName("x")
    val x: List<TdTestInt> = emptyList(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdTestVectorIntObject> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTestCallVectorIntObject {
        return copy(extra = extra.copy(id = id))
    }
}
