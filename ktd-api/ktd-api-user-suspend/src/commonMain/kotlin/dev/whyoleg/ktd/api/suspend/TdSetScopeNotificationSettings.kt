package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes notification settings for chats of a given type
 *
 * @property scope Types of chats for which to change the notification settings
 * @property notificationSettings The new notification settings for the given scope
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setScopeNotificationSettings(
    scope: TdNotificationSettingsScope? = null,
    notificationSettings: TdScopeNotificationSettings? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetScopeNotificationSettings(scope, notificationSettings, extra))
