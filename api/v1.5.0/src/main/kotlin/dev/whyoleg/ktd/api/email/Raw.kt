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
 */
suspend fun TelegramClient.email(
    f: GetRecoveryEmailAddress
): RecoveryEmailAddress = exec(f) as RecoveryEmailAddress

/**
 * Requests to send a password recovery code to an email address that was previously set up
 */
suspend fun TelegramClient.email(
    f: RequestPasswordRecovery
): EmailAddressAuthenticationCodeInfo = exec(f) as EmailAddressAuthenticationCodeInfo

/**
 * Sends a code to verify an email address to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.email(
    f: SendEmailAddressVerificationCode
): EmailAddressAuthenticationCodeInfo = exec(f) as EmailAddressAuthenticationCodeInfo

/**
 * Re-sends the code to verify an email address to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.email(
    f: ResendEmailAddressVerificationCode
): EmailAddressAuthenticationCodeInfo = exec(f) as EmailAddressAuthenticationCodeInfo
