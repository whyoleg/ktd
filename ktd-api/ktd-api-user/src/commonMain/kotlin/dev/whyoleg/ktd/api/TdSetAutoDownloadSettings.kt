package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sets auto-download settings
 *
 * @property settings New user auto-download settings
 * @property type Type of the network for which the new settings are applied
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setAutoDownloadSettings")
data class TdSetAutoDownloadSettings(
    @SerialName("settings")
    val settings: TdAutoDownloadSettings? = null,
    @SerialName("type")
    val type: TdNetworkType? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetAutoDownloadSettings {
        return copy(extra = extra.copy(id = id))
    }
}
