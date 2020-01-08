@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.passport

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Adds an element to the user's Telegram Passport
 * May return an error with a message "PHONE_VERIFICATION_NEEDED" or "EMAIL_VERIFICATION_NEEDED" if the chosen phone number or the chosen email address must be verified first
 *
 * @element - Input Telegram Passport element
 * @password - Password of the current user
 */
suspend fun TelegramClient.setPassportElement(
    element: InputPassportElement? = null,
    password: String? = null
): PassportElement = passport(
    SetPassportElement(
        element,
        password
    )
)

/**
 * Adds an element to the user's Telegram Passport
 * May return an error with a message "PHONE_VERIFICATION_NEEDED" or "EMAIL_VERIFICATION_NEEDED" if the chosen phone number or the chosen email address must be verified first
 */
suspend fun TelegramClient.passport(
    f: SetPassportElement
): PassportElement = exec(f) as PassportElement
