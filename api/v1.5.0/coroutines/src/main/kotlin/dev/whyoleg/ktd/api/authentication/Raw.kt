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
 */
suspend fun TelegramClient.authentication(
    f: SetAuthenticationPhoneNumber
): Ok = exec(f) as Ok

/**
 * Re-sends an authentication code to the user
 * Works only when the current authorization state is authorizationStateWaitCode and the next_code_type of the result is not null
 */
suspend fun TelegramClient.authentication(
    f: ResendAuthenticationCode
): Ok = exec(f) as Ok

/**
 * Requests to send a password recovery code to an email address that was previously set up
 * Works only when the current authorization state is authorizationStateWaitPassword
 */
suspend fun TelegramClient.authentication(
    f: RequestAuthenticationPasswordRecovery
): Ok = exec(f) as Ok

/**
 * Recovers the password with a password recovery code sent to an email address that was previously set up
 * Works only when the current authorization state is authorizationStateWaitPassword
 */
suspend fun TelegramClient.authentication(
    f: RecoverAuthenticationPassword
): Ok = exec(f) as Ok

/**
 * Changes the phone number of the user and sends an authentication code to the user's new phone number
 * On success, returns information about the sent code
 */
suspend fun TelegramClient.authentication(
    f: ChangePhoneNumber
): AuthenticationCodeInfo = exec(f) as AuthenticationCodeInfo

/**
 * Re-sends the authentication code sent to confirm a new phone number for the user
 * Works only if the previously received authenticationCodeInfo next_code_type was not null
 */
suspend fun TelegramClient.authentication(
    f: ResendChangePhoneNumberCode
): AuthenticationCodeInfo = exec(f) as AuthenticationCodeInfo

/**
 * Sends a code to verify a phone number to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.authentication(
    f: SendPhoneNumberVerificationCode
): AuthenticationCodeInfo = exec(f) as AuthenticationCodeInfo

/**
 * Re-sends the code to verify a phone number to be added to a user's Telegram Passport
 */
suspend fun TelegramClient.authentication(
    f: ResendPhoneNumberVerificationCode
): AuthenticationCodeInfo = exec(f) as AuthenticationCodeInfo

/**
 * Sends phone number confirmation code
 * Should be called when user presses "https://t.me/confirmphone?phone=*******&hash=**********" or "tg://confirmphone?phone=*******&hash=**********" link
 */
suspend fun TelegramClient.authentication(
    f: SendPhoneNumberConfirmationCode
): AuthenticationCodeInfo = exec(f) as AuthenticationCodeInfo

/**
 * Resends phone number confirmation code
 */
suspend fun TelegramClient.authentication(
    f: ResendPhoneNumberConfirmationCode
): AuthenticationCodeInfo = exec(f) as AuthenticationCodeInfo
