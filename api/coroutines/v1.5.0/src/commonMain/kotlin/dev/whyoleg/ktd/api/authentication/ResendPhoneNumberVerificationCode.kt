@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.authentication

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Re-sends the code to verify a phone number to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.resendPhoneNumberVerificationCode(): AuthenticationCodeInfo = authentication(
    ResendPhoneNumberVerificationCode()
)

/**
 * Re-sends the code to verify a phone number to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.authentication(
    f: ResendPhoneNumberVerificationCode
): AuthenticationCodeInfo = exec(f) as AuthenticationCodeInfo
