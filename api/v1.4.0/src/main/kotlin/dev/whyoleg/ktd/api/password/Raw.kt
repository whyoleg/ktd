@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.password

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the current state of 2-step verification
 */
suspend fun TelegramClient.password(
    f: GetPasswordState
): PasswordState = exec(f) as PasswordState

/**
 * Changes the password for the user
 * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
 */
suspend fun TelegramClient.password(
    f: SetPassword
): PasswordState = exec(f) as PasswordState

/**
 * Changes the 2-step verification recovery email address of the user
 * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed If new_recovery_email_address is the same as the email address that is currently set up, this call succeeds immediately and aborts all other requests waiting for an email confirmation
 */
suspend fun TelegramClient.password(
    f: SetRecoveryEmailAddress
): PasswordState = exec(f) as PasswordState

/**
 * Checks the 2-step verification recovery email address verification code
 */
suspend fun TelegramClient.password(
    f: CheckRecoveryEmailAddressCode
): PasswordState = exec(f) as PasswordState

/**
 * Resends the 2-step verification recovery email address verification code
 */
suspend fun TelegramClient.password(
    f: ResendRecoveryEmailAddressCode
): PasswordState = exec(f) as PasswordState

/**
 * Recovers the password using a recovery code sent to an email address that was previously set up
 */
suspend fun TelegramClient.password(
    f: RecoverPassword
): PasswordState = exec(f) as PasswordState

/**
 * Creates a new temporary password for processing payments
 */
suspend fun TelegramClient.password(
    f: CreateTemporaryPassword
): TemporaryPasswordState = exec(f) as TemporaryPasswordState

/**
 * Returns information about the current temporary password
 */
suspend fun TelegramClient.password(
    f: GetTemporaryPasswordState
): TemporaryPasswordState = exec(f) as TemporaryPasswordState
