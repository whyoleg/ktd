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
 * Sends a code to verify an email address to be added to a user's Telegram Passport
 *
 * @emailAddress - Email address
 */
suspend fun TelegramClient.sendEmailAddressVerificationCode(
    emailAddress: String? = null
): EmailAddressAuthenticationCodeInfo = email(
    SendEmailAddressVerificationCode(
        emailAddress
    )
)

/**
 * Sends a code to verify an email address to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.email(
    f: SendEmailAddressVerificationCode
): EmailAddressAuthenticationCodeInfo = exec(f) as EmailAddressAuthenticationCodeInfo
