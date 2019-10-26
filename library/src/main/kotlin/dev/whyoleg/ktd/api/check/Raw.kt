@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.check

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Checks the database encryption key for correctness
 * Works only when the current authorization state is authorizationStateWaitEncryptionKey
 */
suspend fun TelegramClient.check(
    f: CheckDatabaseEncryptionKey
): Ok = exec(f) as Ok

/**
 * Checks the authentication code
 * Works only when the current authorization state is authorizationStateWaitCode
 */
suspend fun TelegramClient.check(
    f: CheckAuthenticationCode
): Ok = exec(f) as Ok

/**
 * Checks the authentication password for correctness
 * Works only when the current authorization state is authorizationStateWaitPassword
 */
suspend fun TelegramClient.check(
    f: CheckAuthenticationPassword
): Ok = exec(f) as Ok

/**
 * Checks the authentication token of a bot
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber
 * Can be used instead of setAuthenticationPhoneNumber and checkAuthenticationCode to log in
 */
@BotsOnly
suspend fun TelegramClient.check(
    f: CheckAuthenticationBotToken
): Ok = exec(f) as Ok

/**
 * Checks whether a username can be set for a chat
 */
suspend fun TelegramClient.check(
    f: CheckChatUsername
): CheckChatUsernameResult = exec(f) as CheckChatUsernameResult

/**
 * Sets the result of a pre-checkout query
 */
@BotsOnly
suspend fun TelegramClient.check(
    f: AnswerPreCheckoutQuery
): Ok = exec(f) as Ok

/**
 * Checks the authentication code sent to confirm a new phone number of the user
 */
suspend fun TelegramClient.check(
    f: CheckChangePhoneNumberCode
): Ok = exec(f) as Ok

/**
 * Checks the phone number verification code for Telegram Passport
 */
suspend fun TelegramClient.check(
    f: CheckPhoneNumberVerificationCode
): Ok = exec(f) as Ok

/**
 * Checks the email address verification code for Telegram Passport
 */
suspend fun TelegramClient.check(
    f: CheckEmailAddressVerificationCode
): Ok = exec(f) as Ok

/**
 * Checks phone number confirmation code
 */
suspend fun TelegramClient.check(
    f: CheckPhoneNumberConfirmationCode
): Ok = exec(f) as Ok
