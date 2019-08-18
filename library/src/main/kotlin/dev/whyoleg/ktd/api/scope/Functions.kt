@file:Suppress("unused")

package dev.whyoleg.ktd.api.scope

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the notification settings for chats of a given type
 */
suspend fun TelegramClient.scope(
    f: GetScopeNotificationSettings
): ScopeNotificationSettings = execRaw(f) as ScopeNotificationSettings

/**
 * Changes notification settings for chats of a given type
 */
suspend fun TelegramClient.scope(
    f: SetScopeNotificationSettings
): Ok = execRaw(f) as Ok
