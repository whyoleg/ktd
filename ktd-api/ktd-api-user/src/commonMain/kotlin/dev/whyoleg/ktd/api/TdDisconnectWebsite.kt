package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Disconnects website from the current user's Telegram account
 *
 * @property websiteId Website identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("disconnectWebsite")
data class TdDisconnectWebsite(
    @SerialName("website_id")
    val websiteId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDisconnectWebsite {
        return copy(extra = extra.copy(id = id))
    }
}
