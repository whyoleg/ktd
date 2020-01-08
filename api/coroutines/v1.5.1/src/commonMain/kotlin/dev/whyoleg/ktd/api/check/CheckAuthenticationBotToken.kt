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
 * Checks the authentication token of a bot
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber
 * Can be used instead of setAuthenticationPhoneNumber and checkAuthenticationCode to log in
 */
@BotsOnly
suspend fun TelegramClient.check(
    f: CheckAuthenticationBotToken
): Ok = exec(f) as Ok
