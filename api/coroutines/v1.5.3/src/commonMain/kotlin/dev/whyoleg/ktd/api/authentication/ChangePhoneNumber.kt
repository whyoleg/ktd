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
 * Changes the phone number of the user and sends an authentication code to the user's new phone number
 * On success, returns information about the sent code
 *
 * @phoneNumber - The new phone number of the user in international format
 * @settings - Settings for the authentication of the user's phone number
 */
suspend fun TelegramClient.changePhoneNumber(
    phoneNumber: String? = null,
    settings: PhoneNumberAuthenticationSettings? = null
): AuthenticationCodeInfo = authentication(
    ChangePhoneNumber(
        phoneNumber,
        settings
    )
)

/**
 * Changes the phone number of the user and sends an authentication code to the user's new phone number
 * On success, returns information about the sent code
 */
suspend fun TelegramClient.authentication(
    f: ChangePhoneNumber
): AuthenticationCodeInfo = exec(f) as AuthenticationCodeInfo
