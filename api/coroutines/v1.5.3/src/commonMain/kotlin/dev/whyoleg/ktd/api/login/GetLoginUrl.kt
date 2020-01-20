@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.login

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns an HTTP URL which can be used to automatically authorize the user on a website after clicking an inline button of type inlineKeyboardButtonTypeLoginUrl
 * Use the method getLoginUrlInfo to find whether a prior user confirmation is needed
 * If an error is returned, then the button must be handled as an ordinary URL button
 *
 * @chatId - Chat identifier of the message with the button
 * @messageId - Message identifier of the message with the button
 * @buttonId - Button identifier
 * @allowWriteAccess - True, if the user allowed the bot to send them messages
 */
suspend fun TelegramClient.getLoginUrl(
    chatId: Long = 0L,
    messageId: Long = 0L,
    buttonId: Int = 0,
    allowWriteAccess: Boolean = false
): HttpUrl = login(
    GetLoginUrl(
        chatId,
        messageId,
        buttonId,
        allowWriteAccess
    )
)

/**
 * Returns an HTTP URL which can be used to automatically authorize the user on a website after clicking an inline button of type inlineKeyboardButtonTypeLoginUrl
 * Use the method getLoginUrlInfo to find whether a prior user confirmation is needed
 * If an error is returned, then the button must be handled as an ordinary URL button
 */
suspend fun TelegramClient.login(
    f: GetLoginUrl
): HttpUrl = exec(f) as HttpUrl
