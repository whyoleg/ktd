@file:Suppress("unused")

package dev.whyoleg.ktd.api.recovery

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a 2-step verification recovery email address that was previously set up. This method can be used to verify a password provided by the user
 */
suspend fun TelegramClient.recovery(
    f: GetRecoveryEmailAddress
): RecoveryEmailAddress = execRaw(f) as RecoveryEmailAddress
