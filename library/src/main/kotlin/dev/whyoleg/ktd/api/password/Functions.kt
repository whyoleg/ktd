@file:Suppress("unused")

package dev.whyoleg.ktd.api.password

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the current state of 2-step verification
 */
suspend fun TelegramClient.password(
    f: GetPasswordState
): PasswordState = execRaw(f) as PasswordState

/**
 * Changes the password for the user. If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
 */
suspend fun TelegramClient.password(
    f: SetPassword
): PasswordState = execRaw(f) as PasswordState

/**
 * Changes the 2-step verification recovery email address of the user. If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed.
 * If newRecoveryEmailAddress is the same as the email address that is currently set up, this call succeeds immediately and aborts all other requests waiting for an email confirmation
 */
suspend fun TelegramClient.password(
    f: SetRecoveryEmailAddress
): PasswordState = execRaw(f) as PasswordState

/**
 * Checks the 2-step verification recovery email address verification code
 */
suspend fun TelegramClient.password(
    f: CheckRecoveryEmailAddressCode
): PasswordState = execRaw(f) as PasswordState

/**
 * Resends the 2-step verification recovery email address verification code
 */
suspend fun TelegramClient.password(
    f: ResendRecoveryEmailAddressCode
): PasswordState = execRaw(f) as PasswordState

/**
 * Recovers the password using a recovery code sent to an email address that was previously set up
 */
suspend fun TelegramClient.password(
    f: RecoverPassword
): PasswordState = execRaw(f) as PasswordState
