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
 * Sets auto-download settings
 *
 * @settings - New user auto-download settings
 * @type - Type of the network for which the new settings are applied
 */
suspend fun TelegramClient.setAutoDownloadSettings(
    settings: AutoDownloadSettings? = null,
    type: NetworkType? = null
): Ok = auto(
    SetAutoDownloadSettings(
        settings,
        type
    )
)

/**
 * Sets auto-download settings
 */
suspend fun TelegramClient.auto(
    f: SetAutoDownloadSettings
): Ok = exec(f) as Ok
