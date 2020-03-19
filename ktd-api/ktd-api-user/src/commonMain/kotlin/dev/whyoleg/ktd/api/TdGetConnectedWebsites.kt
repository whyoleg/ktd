package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns all website where the current user used Telegram to log in
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getConnectedWebsites")
data class TdGetConnectedWebsites(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdConnectedWebsites> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetConnectedWebsites {
        return copy(extra = extra.copy(id = id))
    }
}
