@file:Suppress("unused")

package dev.whyoleg.ktd.api.password

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the current state of 2-step verification
 */
suspend fun TelegramClient.getPasswordState(): PasswordState = password(
    GetPasswordState()
)

/**
 * Changes the password for the user. If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
 *
 * @oldPassword - Previous password of the user
 * @newPassword - New password of the user; may be empty to remove the password
 * @newHint - New password hint; may be empty
 * @setRecoveryEmailAddress - Pass true if the recovery email address should be changed
 * @newRecoveryEmailAddress - New recovery email address; may be empty
 */
suspend fun TelegramClient.setPassword(
    oldPassword: String,
    newPassword: String,
    newHint: String,
    setRecoveryEmailAddress: Boolean,
    newRecoveryEmailAddress: String
): PasswordState = password(
    SetPassword(
        oldPassword,
        newPassword,
        newHint,
        setRecoveryEmailAddress,
        newRecoveryEmailAddress
    )
)

/**
 * Changes the 2-step verification recovery email address of the user. If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed.
 * If newRecoveryEmailAddress is the same as the email address that is currently set up, this call succeeds immediately and aborts all other requests waiting for an email confirmation
 *
 * @password - Password of the current user
 * @newRecoveryEmailAddress - New recovery email address
 */
suspend fun TelegramClient.setRecoveryEmailAddress(
    password: String,
    newRecoveryEmailAddress: String
): PasswordState = password(
    SetRecoveryEmailAddress(
        password,
        newRecoveryEmailAddress
    )
)

/**
 * Checks the 2-step verification recovery email address verification code
 *
 * @code - Verification code
 */
suspend fun TelegramClient.checkRecoveryEmailAddressCode(
    code: String
): PasswordState = password(
    CheckRecoveryEmailAddressCode(
        code
    )
)

/**
 * Resends the 2-step verification recovery email address verification code
 */
suspend fun TelegramClient.resendRecoveryEmailAddressCode(): PasswordState = password(
    ResendRecoveryEmailAddressCode()
)

/**
 * Recovers the password using a recovery code sent to an email address that was previously set up
 *
 * @recoveryCode - Recovery code to check
 */
suspend fun TelegramClient.recoverPassword(
    recoveryCode: String
): PasswordState = password(
    RecoverPassword(
        recoveryCode
    )
)
