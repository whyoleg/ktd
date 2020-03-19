package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains auto-download settings presets for the user
 *
 * @property low Preset with lowest settings
 *               Supposed to be used by default when roaming
 * @property medium Preset with medium settings
 *                  Supposed to be used by default when using mobile data
 * @property high Preset with highest settings
 *                Supposed to be used by default when connected on Wi-Fi
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("autoDownloadSettingsPresets")
data class TdAutoDownloadSettingsPresets(
    @SerialName("low")
    val low: TdAutoDownloadSettings,
    @SerialName("medium")
    val medium: TdAutoDownloadSettings,
    @SerialName("high")
    val high: TdAutoDownloadSettings,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
