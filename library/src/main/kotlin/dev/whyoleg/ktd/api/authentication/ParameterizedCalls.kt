@file:Suppress("unused")

package dev.whyoleg.ktd.api.authentication

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sets the phone number of the user and sends an authentication code to the user. Works only when the current authorization state is authorizationStateWaitPhoneNumber,
 * or if there is no pending authentication query and the current authorization state is authorizationStateWaitCode or authorizationStateWaitPassword
 *
 * @phoneNumber - The phone number of the user, in international format
 * @settings - Settings for the authentication of the user's phone number
 */
suspend fun TelegramClient.setAuthenticationPhoneNumber(
    phoneNumber: String,
    settings: PhoneNumberAuthenticationSettings
): Ok = authentication(
    SetAuthenticationPhoneNumber(
        phoneNumber,
        settings
    )
)

/**
 * Re-sends an authentication code to the user. Works only when the current authorization state is authorizationStateWaitCode and the next_code_type of the result is not null
 */
suspend fun TelegramClient.resendAuthenticationCode(): Ok = authentication(
    ResendAuthenticationCode()
)

/**
 * Requests to send a password recovery code to an email address that was previously set up. Works only when the current authorization state is authorizationStateWaitPassword
 */
suspend fun TelegramClient.requestAuthenticationPasswordRecovery(): Ok = authentication(
    RequestAuthenticationPasswordRecovery()
)

/**
 * Recovers the password with a password recovery code sent to an email address that was previously set up. Works only when the current authorization state is authorizationStateWaitPassword
 *
 * @recoveryCode - Recovery code to check
 */
suspend fun TelegramClient.recoverAuthenticationPassword(
    recoveryCode: String
): Ok = authentication(
    RecoverAuthenticationPassword(
        recoveryCode
    )
)

/**
 * Changes the phone number of the user and sends an authentication code to the user's new phone number. On success, returns information about the sent code
 *
 * @phoneNumber - The new phone number of the user in international format
 * @settings - Settings for the authentication of the user's phone number
 */
suspend fun TelegramClient.changePhoneNumber(
    phoneNumber: String,
    settings: PhoneNumberAuthenticationSettings
): AuthenticationCodeInfo = authentication(
    ChangePhoneNumber(
        phoneNumber,
        settings
    )
)

/**
 * Re-sends the authentication code sent to confirm a new phone number for the user. Works only if the previously received authenticationCodeInfo next_code_type was not null
 */
suspend fun TelegramClient.resendChangePhoneNumberCode(): AuthenticationCodeInfo = authentication(
    ResendChangePhoneNumberCode()
)

/**
 * Sends a code to verify a phone number to be added to a user's Telegram Passport
 *
 * @phoneNumber - The phone number of the user, in international format
 * @settings - Settings for the authentication of the user's phone number
 */
suspend fun TelegramClient.sendPhoneNumberVerificationCode(
    phoneNumber: String,
    settings: PhoneNumberAuthenticationSettings
): AuthenticationCodeInfo = authentication(
    SendPhoneNumberVerificationCode(
        phoneNumber,
        settings
    )
)

/**
 * Re-sends the code to verify a phone number to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.resendPhoneNumberVerificationCode(): AuthenticationCodeInfo = authentication(
    ResendPhoneNumberVerificationCode()
)

/**
 * Sends phone number confirmation code. Should be called when user presses "https:t.me/confirmphone?phone=*******&hash=**********" or "tg:confirmphone?phone=*******&hash=**********" link
 *
 * @hash - Value of the "hash" parameter from the link
 * @phoneNumber - Value of the "phone" parameter from the link
 * @settings - Settings for the authentication of the user's phone number
 */
suspend fun TelegramClient.sendPhoneNumberConfirmationCode(
    hash: String,
    phoneNumber: String,
    settings: PhoneNumberAuthenticationSettings
): AuthenticationCodeInfo = authentication(
    SendPhoneNumberConfirmationCode(
        hash,
        phoneNumber,
        settings
    )
)

/**
 * Resends phone number confirmation code
 */
suspend fun TelegramClient.resendPhoneNumberConfirmationCode(): AuthenticationCodeInfo = authentication(
    ResendPhoneNumberConfirmationCode()
)
