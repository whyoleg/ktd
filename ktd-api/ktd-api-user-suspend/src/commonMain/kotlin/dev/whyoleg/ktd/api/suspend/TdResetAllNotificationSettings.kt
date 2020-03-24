package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Resets all notification settings to their default values
 * By default, all chats are unmuted, the sound is set to "default" and message previews are shown
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.resetAllNotificationSettings(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdResetAllNotificationSettings(extra))
