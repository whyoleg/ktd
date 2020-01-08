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
 * Sends phone number confirmation code
 * Should be called when user presses "https://t.me/confirmphone?phone=*******&hash=**********" or "tg://confirmphone?phone=*******&hash=**********" link
 *
 * @hash - Value of the "hash" parameter from the link
 * @phoneNumber - Value of the "phone" parameter from the link
 * @settings - Settings for the authentication of the user's phone number
 */
suspend fun TelegramClient.sendPhoneNumberConfirmationCode(
    hash: String? = null,
    phoneNumber: String? = null,
    settings: PhoneNumberAuthenticationSettings? = null
): AuthenticationCodeInfo = authentication(
    SendPhoneNumberConfirmationCode(
        hash,
        phoneNumber,
        settings
    )
)

/**
 * Sends phone number confirmation code
 * Should be called when user presses "https://t.me/confirmphone?phone=*******&hash=**********" or "tg://confirmphone?phone=*******&hash=**********" link
 */
suspend fun TelegramClient.authentication(
    f: SendPhoneNumberConfirmationCode
): AuthenticationCodeInfo = exec(f) as AuthenticationCodeInfo
