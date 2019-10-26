@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.auto

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns auto-download settings presets for the currently logged in user
 */
suspend fun TelegramClient.auto(
    f: GetAutoDownloadSettingsPresets
): AutoDownloadSettingsPresets = exec(f) as AutoDownloadSettingsPresets

/**
 * Sets auto-download settings
 */
suspend fun TelegramClient.auto(
    f: SetAutoDownloadSettings
): Ok = exec(f) as Ok
