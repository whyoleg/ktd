package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns auto-download settings presets for the currently logged in user
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getAutoDownloadSettingsPresets")
data class TdGetAutoDownloadSettingsPresets(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdAutoDownloadSettingsPresets> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetAutoDownloadSettingsPresets {
        return copy(extra = extra.copy(id = id))
    }
}
