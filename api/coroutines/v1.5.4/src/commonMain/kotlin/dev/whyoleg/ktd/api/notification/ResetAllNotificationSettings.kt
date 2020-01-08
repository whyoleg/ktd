@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.notification

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Resets all notification settings to their default values
 * By default, all chats are unmuted, the sound is set to "default" and message previews are shown
 */
suspend fun TelegramClient.resetAllNotificationSettings(): Ok = notification(
    ResetAllNotificationSettings()
)

/**
 * Resets all notification settings to their default values
 * By default, all chats are unmuted, the sound is set to "default" and message previews are shown
 */
suspend fun TelegramClient.notification(
    f: ResetAllNotificationSettings
): Ok = exec(f) as Ok
