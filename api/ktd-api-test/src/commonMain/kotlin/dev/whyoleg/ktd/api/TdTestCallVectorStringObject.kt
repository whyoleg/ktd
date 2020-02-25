package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the received vector of objects containing a string
 * This is an offline method
 * Can be called before authorization
 *
 * @property x Vector of objects to return
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testCallVectorStringObject")
data class TdTestCallVectorStringObject(
    @SerialName("x")
    val x: List<TdTestString> = emptyList(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdTestVectorStringObject> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTestCallVectorStringObject {
        return copy(extra = extra.copy(id = id))
    }
}
