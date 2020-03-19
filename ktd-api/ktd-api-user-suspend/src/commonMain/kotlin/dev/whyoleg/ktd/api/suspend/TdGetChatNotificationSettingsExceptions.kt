package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns list of chats with non-default notification settings
 *
 * @property scope If specified, only chats from the specified scope will be returned
 * @property compareSound If true, also chats with non-default sound will be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getChatNotificationSettingsExceptions(
    scope: TdNotificationSettingsScope? = null,
    compareSound: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdChats = exec(TdGetChatNotificationSettingsExceptions(scope, compareSound, extra))
