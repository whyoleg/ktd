@file:Suppress("unused")

package dev.whyoleg.ktd.api.auto

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns auto-download settings presets for the currently logged in user
 */
suspend fun TelegramClient.getAutoDownloadSettingsPresets(): AutoDownloadSettingsPresets = auto(
    GetAutoDownloadSettingsPresets()
)

/**
 * Sets auto-download settings
 *
 * @settings - New user auto-download settings
 * @type - Type of the network for which the new settings are applied
 */
suspend fun TelegramClient.setAutoDownloadSettings(
    settings: AutoDownloadSettings,
    type: NetworkType
): Ok = auto(
    SetAutoDownloadSettings(
        settings,
        type
    )
)
