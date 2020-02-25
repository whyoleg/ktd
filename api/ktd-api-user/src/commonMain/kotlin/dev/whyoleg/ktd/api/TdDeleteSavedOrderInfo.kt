package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Deletes saved order info
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deleteSavedOrderInfo")
data class TdDeleteSavedOrderInfo(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDeleteSavedOrderInfo {
        return copy(extra = extra.copy(id = id))
    }
}
