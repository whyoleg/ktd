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
 * Sends a code to verify a phone number to be added to a user's Telegram Passport
 *
 * @phoneNumber - The phone number of the user, in international format
 * @settings - Settings for the authentication of the user's phone number
 */
suspend fun TelegramClient.sendPhoneNumberVerificationCode(
    phoneNumber: String? = null,
    settings: PhoneNumberAuthenticationSettings? = null
): AuthenticationCodeInfo = authentication(
    SendPhoneNumberVerificationCode(
        phoneNumber,
        settings
    )
)

/**
 * Sends a code to verify a phone number to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.authentication(
    f: SendPhoneNumberVerificationCode
): AuthenticationCodeInfo = exec(f) as AuthenticationCodeInfo
