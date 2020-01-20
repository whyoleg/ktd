@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.email

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a 2-step verification recovery email address that was previously set up
 * This method can be used to verify a password provided by the user
 *
 * @password - The password for the current user
 */
suspend fun TelegramClient.getRecoveryEmailAddress(
    password: String? = null
): RecoveryEmailAddress = email(
    GetRecoveryEmailAddress(
        password
    )
)

/**
 * Returns a 2-step verification recovery email address that was previously set up
 * This method can be used to verify a password provided by the user
 */
suspend fun TelegramClient.email(
    f: GetRecoveryEmailAddress
): RecoveryEmailAddress = exec(f) as RecoveryEmailAddress
