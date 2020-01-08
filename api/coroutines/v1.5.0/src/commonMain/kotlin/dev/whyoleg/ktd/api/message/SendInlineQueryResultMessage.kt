@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sends the result of an inline query as a message
 * Returns the sent message
 * Always clears a chat draft message
 *
 * @chatId - Target chat
 * @replyToMessageId - Identifier of a message to reply to or 0
 * @disableNotification - Pass true to disable notification for the message
 *                        Not supported in secret chats
 * @fromBackground - Pass true if the message is sent from background
 * @queryId - Identifier of the inline query
 * @resultId - Identifier of the inline result
 * @hideViaBot - If true, there will be no mention of a bot, via which the message is sent
 *               Can be used only for bots GetOption("animation_search_bot_username"), GetOption("photo_search_bot_username") and GetOption("venue_search_bot_username")
 */
suspend fun TelegramClient.sendInlineQueryResultMessage(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    disableNotification: Boolean = false,
    fromBackground: Boolean = false,
    queryId: Long = 0L,
    resultId: String? = null,
    hideViaBot: Boolean = false
): Message = message(
    SendInlineQueryResultMessage(
        chatId,
        replyToMessageId,
        disableNotification,
        fromBackground,
        queryId,
        resultId,
        hideViaBot
    )
)

/**
 * Sends the result of an inline query as a message
 * Returns the sent message
 * Always clears a chat draft message
 */
suspend fun TelegramClient.message(
    f: SendInlineQueryResultMessage
): Message = exec(f) as Message
