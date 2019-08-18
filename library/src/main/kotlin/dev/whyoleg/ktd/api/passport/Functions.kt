@file:Suppress("unused")

package dev.whyoleg.ktd.api.passport

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns one of the available Telegram Passport elements
 */
suspend fun TelegramClient.passport(
    f: GetPassportElement
): PassportElement = execRaw(f) as PassportElement

/**
 * Returns all available Telegram Passport elements
 */
suspend fun TelegramClient.passport(
    f: GetAllPassportElements
): PassportElements = execRaw(f) as PassportElements

/**
 * Adds an element to the user's Telegram Passport. May return an error with a message "PHONE_VERIFICATION_NEEDED" or "EMAIL_VERIFICATION_NEEDED" if the chosen phone number or the chosen email address must be verified first
 */
suspend fun TelegramClient.passport(
    f: SetPassportElement
): PassportElement = execRaw(f) as PassportElement

/**
 * Deletes a Telegram Passport element
 */
suspend fun TelegramClient.passport(
    f: DeletePassportElement
): Ok = execRaw(f) as Ok

/**
 * Informs the user that some of the elements in their Telegram Passport contain errors; for bots only. The user will not be able to resend the elements, until the errors are fixed
 */
suspend fun TelegramClient.passport(
    f: SetPassportElementErrors
): Ok = execRaw(f) as Ok

/**
 * Returns a Telegram Passport authorization form for sharing data with a service
 */
suspend fun TelegramClient.passport(
    f: GetPassportAuthorizationForm
): PassportAuthorizationForm = execRaw(f) as PassportAuthorizationForm

/**
 * Returns already available Telegram Passport elements suitable for completing a Telegram Passport authorization form. Result can be received only once for each authorization form
 */
suspend fun TelegramClient.passport(
    f: GetPassportAuthorizationFormAvailableElements
): PassportElementsWithErrors = execRaw(f) as PassportElementsWithErrors

/**
 * Sends a Telegram Passport authorization form, effectively sharing data with the service. This method must be called after getPassportAuthorizationFormAvailableElements if some previously available elements need to be used
 */
suspend fun TelegramClient.passport(
    f: SendPassportAuthorizationForm
): Ok = execRaw(f) as Ok
