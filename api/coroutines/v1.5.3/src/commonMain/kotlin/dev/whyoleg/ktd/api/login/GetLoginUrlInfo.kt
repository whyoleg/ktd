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
 * Returns information about a button of type inlineKeyboardButtonTypeLoginUrl
 * The method needs to be called when the user presses the button
 *
 * @chatId - Chat identifier of the message with the button
 * @messageId - Message identifier of the message with the button
 * @buttonId - Button identifier
 */
suspend fun TelegramClient.getLoginUrlInfo(
    chatId: Long = 0L,
    messageId: Long = 0L,
    buttonId: Int = 0
): LoginUrlInfo = login(
    GetLoginUrlInfo(
        chatId,
        messageId,
        buttonId
    )
)

/**
 * Returns information about a button of type inlineKeyboardButtonTypeLoginUrl
 * The method needs to be called when the user presses the button
 */
suspend fun TelegramClient.login(
    f: GetLoginUrlInfo
): LoginUrlInfo = exec(f) as LoginUrlInfo
