@file:Suppress("unused")

package dev.whyoleg.ktd.api.recovery

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a 2-step verification recovery email address that was previously set up. This method can be used to verify a password provided by the user
 *
 * @password - The password for the current user
 */
suspend fun TelegramClient.getRecoveryEmailAddress(
    password: String
): RecoveryEmailAddress = recovery(
    GetRecoveryEmailAddress(
        password
    )
)
