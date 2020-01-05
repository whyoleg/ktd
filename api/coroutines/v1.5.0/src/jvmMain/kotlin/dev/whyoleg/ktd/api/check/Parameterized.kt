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
 *
 * @encryptionKey - Encryption key to check or set up
 */
suspend fun TelegramClient.checkDatabaseEncryptionKey(
    encryptionKey: ByteArray = byteArrayOf()
): Ok = check(
    CheckDatabaseEncryptionKey(
        encryptionKey
    )
)

/**
 * Checks the authentication code
 * Works only when the current authorization state is authorizationStateWaitCode
 *
 * @code - The verification code received via SMS, Telegram message, phone call, or flash call
 */
suspend fun TelegramClient.checkAuthenticationCode(
    code: String? = null
): Ok = check(
    CheckAuthenticationCode(
        code
    )
)

/**
 * Checks the authentication password for correctness
 * Works only when the current authorization state is authorizationStateWaitPassword
 *
 * @password - The password to check
 */
suspend fun TelegramClient.checkAuthenticationPassword(
    password: String? = null
): Ok = check(
    CheckAuthenticationPassword(
        password
    )
)

/**
 * Checks the authentication token of a bot
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber
 * Can be used instead of setAuthenticationPhoneNumber and checkAuthenticationCode to log in
 *
 * @token - The bot token
 */
@BotsOnly
suspend fun TelegramClient.checkAuthenticationBotToken(
    token: String? = null
): Ok = check(
    CheckAuthenticationBotToken(
        token
    )
)

/**
 * Checks whether a username can be set for a chat
 *
 * @chatId - Chat identifier
 *           Should be identifier of a supergroup chat, or a channel chat, or a private chat with self, or zero if chat is being created
 * @username - Username to be checked
 */
suspend fun TelegramClient.checkChatUsername(
    chatId: Long = 0L,
    username: String? = null
): CheckChatUsernameResult = check(
    CheckChatUsername(
        chatId,
        username
    )
)

/**
 * Sets the result of a pre-checkout query
 *
 * @preCheckoutQueryId - Identifier of the pre-checkout query
 * @errorMessage - An error message, empty on success
 */
@BotsOnly
suspend fun TelegramClient.answerPreCheckoutQuery(
    preCheckoutQueryId: Long = 0L,
    errorMessage: String? = null
): Ok = check(
    AnswerPreCheckoutQuery(
        preCheckoutQueryId,
        errorMessage
    )
)

/**
 * Checks the authentication code sent to confirm a new phone number of the user
 *
 * @code - Verification code received by SMS, phone call or flash call
 */
suspend fun TelegramClient.checkChangePhoneNumberCode(
    code: String? = null
): Ok = check(
    CheckChangePhoneNumberCode(
        code
    )
)

/**
 * Checks the phone number verification code for Telegram Passport
 *
 * @code - Verification code
 */
suspend fun TelegramClient.checkPhoneNumberVerificationCode(
    code: String? = null
): Ok = check(
    CheckPhoneNumberVerificationCode(
        code
    )
)

/**
 * Checks the email address verification code for Telegram Passport
 *
 * @code - Verification code
 */
suspend fun TelegramClient.checkEmailAddressVerificationCode(
    code: String? = null
): Ok = check(
    CheckEmailAddressVerificationCode(
        code
    )
)

/**
 * Checks phone number confirmation code
 *
 * @code - The phone number confirmation code
 */
suspend fun TelegramClient.checkPhoneNumberConfirmationCode(
    code: String? = null
): Ok = check(
    CheckPhoneNumberConfirmationCode(
        code
    )
)
