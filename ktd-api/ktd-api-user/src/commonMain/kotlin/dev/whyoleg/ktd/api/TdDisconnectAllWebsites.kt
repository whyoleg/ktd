package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Disconnects all websites from the current user's Telegram account
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("disconnectAllWebsites")
data class TdDisconnectAllWebsites(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDisconnectAllWebsites {
        return copy(extra = extra.copy(id = id))
    }
}
