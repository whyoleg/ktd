@file:Suppress("unused")

package dev.whyoleg.ktd.api.email

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Requests to send a password recovery code to an email address that was previously set up
 */
suspend fun TelegramClient.requestPasswordRecovery(): EmailAddressAuthenticationCodeInfo = email(
    RequestPasswordRecovery()
)

/**
 * Sends a code to verify an email address to be added to a user's Telegram Passport
 *
 * @emailAddress - Email address
 */
suspend fun TelegramClient.sendEmailAddressVerificationCode(
    emailAddress: String
): EmailAddressAuthenticationCodeInfo = email(
    SendEmailAddressVerificationCode(
        emailAddress
    )
)

/**
 * Re-sends the code to verify an email address to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.resendEmailAddressVerificationCode(): EmailAddressAuthenticationCodeInfo = email(
    ResendEmailAddressVerificationCode()
)
