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
 * Sets the phone number of the user and sends an authentication code to the user
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber, or if there is no pending authentication query and the current authorization state is authorizationStateWaitCode or authorizationStateWaitPassword
 *
 * @phoneNumber - The phone number of the user, in international format
 * @settings - Settings for the authentication of the user's phone number
 */
suspend fun TelegramClient.setAuthenticationPhoneNumber(
    phoneNumber: String? = null,
    settings: PhoneNumberAuthenticationSettings? = null
): Ok = authentication(
    SetAuthenticationPhoneNumber(
        phoneNumber,
        settings
    )
)

/**
 * Sets the phone number of the user and sends an authentication code to the user
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber, or if there is no pending authentication query and the current authorization state is authorizationStateWaitCode or authorizationStateWaitPassword
 */
suspend fun TelegramClient.authentication(
    f: SetAuthenticationPhoneNumber
): Ok = exec(f) as Ok
