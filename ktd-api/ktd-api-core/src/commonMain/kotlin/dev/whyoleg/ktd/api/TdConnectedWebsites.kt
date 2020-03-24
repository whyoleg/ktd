package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of websites the current user is logged in with Telegram
 *
 * @property websites List of connected websites
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("connectedWebsites")
data class TdConnectedWebsites(
    @SerialName("websites")
    val websites: List<TdConnectedWebsite>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
