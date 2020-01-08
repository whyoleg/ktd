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
 * Re-sends the code to verify an email address to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.resendEmailAddressVerificationCode(): EmailAddressAuthenticationCodeInfo = email(
    ResendEmailAddressVerificationCode()
)

/**
 * Re-sends the code to verify an email address to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.email(
    f: ResendEmailAddressVerificationCode
): EmailAddressAuthenticationCodeInfo = exec(f) as EmailAddressAuthenticationCodeInfo
