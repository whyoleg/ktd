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
 * Changes the password for the user
 * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
 *
 * @oldPassword - Previous password of the user
 * @newPassword - New password of the user
 *                May be empty to remove the password
 * @newHint - New password hint
 * @setRecoveryEmailAddress - Pass true if the recovery email address should be changed
 * @newRecoveryEmailAddress - New recovery email address
 */
suspend fun TelegramClient.setPassword(
    oldPassword: String? = null,
    newPassword: String? = null,
    newHint: String? = null,
    setRecoveryEmailAddress: Boolean = false,
    newRecoveryEmailAddress: String? = null
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
 * Changes the password for the user
 * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
 */
suspend fun TelegramClient.password(
    f: SetPassword
): PasswordState = exec(f) as PasswordState
