@file:Suppress("unused")

package dev.whyoleg.ktd.api.email

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Requests to send a password recovery code to an email address that was previously set up
 */
suspend fun TelegramClient.email(
    f: RequestPasswordRecovery
): EmailAddressAuthenticationCodeInfo = execRaw(f) as EmailAddressAuthenticationCodeInfo

/**
 * Sends a code to verify an email address to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.email(
    f: SendEmailAddressVerificationCode
): EmailAddressAuthenticationCodeInfo = execRaw(f) as EmailAddressAuthenticationCodeInfo

/**
 * Re-sends the code to verify an email address to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.email(
    f: ResendEmailAddressVerificationCode
): EmailAddressAuthenticationCodeInfo = execRaw(f) as EmailAddressAuthenticationCodeInfo
