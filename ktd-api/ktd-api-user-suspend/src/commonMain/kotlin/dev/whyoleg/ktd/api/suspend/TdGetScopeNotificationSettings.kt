package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the notification settings for chats of a given type
 *
 * @property scope Types of chats for which to return the notification settings information
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getScopeNotificationSettings(scope: TdNotificationSettingsScope? = null,
        extra: TdExtra = TdExtra.EMPTY): TdScopeNotificationSettings =
        exec(TdGetScopeNotificationSettings(scope, extra))
