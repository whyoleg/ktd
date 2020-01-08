@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.authentication

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Recovers the password with a password recovery code sent to an email address that was previously set up
 * Works only when the current authorization state is authorizationStateWaitPassword
 *
 * @recoveryCode - Recovery code to check
 */
suspend fun TelegramClient.recoverAuthenticationPassword(
    recoveryCode: String? = null
): Ok = authentication(
    RecoverAuthenticationPassword(
        recoveryCode
    )
)

/**
 * Recovers the password with a password recovery code sent to an email address that was previously set up
 * Works only when the current authorization state is authorizationStateWaitPassword
 */
suspend fun TelegramClient.authentication(
    f: RecoverAuthenticationPassword
): Ok = exec(f) as Ok
