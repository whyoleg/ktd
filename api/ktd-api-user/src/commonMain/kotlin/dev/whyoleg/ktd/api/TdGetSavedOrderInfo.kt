package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns saved order info, if any
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getSavedOrderInfo")
data class TdGetSavedOrderInfo(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOrderInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetSavedOrderInfo {
        return copy(extra = extra.copy(id = id))
    }
}
