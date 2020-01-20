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
 * Changes the 2-step verification recovery email address of the user
 * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
 * If new_recovery_email_address is the same as the email address that is currently set up, this call succeeds immediately and aborts all other requests waiting for an email confirmation
 *
 * @password - Password of the current user
 * @newRecoveryEmailAddress - New recovery email address
 */
suspend fun TelegramClient.setRecoveryEmailAddress(
    password: String? = null,
    newRecoveryEmailAddress: String? = null
): PasswordState = password(
    SetRecoveryEmailAddress(
        password,
        newRecoveryEmailAddress
    )
)

/**
 * Changes the 2-step verification recovery email address of the user
 * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
 * If new_recovery_email_address is the same as the email address that is currently set up, this call succeeds immediately and aborts all other requests waiting for an email confirmation
 */
suspend fun TelegramClient.password(
    f: SetRecoveryEmailAddress
): PasswordState = exec(f) as PasswordState
