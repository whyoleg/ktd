@file:Suppress("unused")

package dev.whyoleg.ktd.api.callback

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sends a callback query to a bot and returns an answer. Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 *
 * @chatId - Identifier of the chat with the message
 * @messageId - Identifier of the message from which the query originated
 * @payload - Query payload
 */
suspend fun TelegramClient.getCallbackQueryAnswer(
    chatId: Long,
    messageId: Long,
    payload: CallbackQueryPayload
): CallbackQueryAnswer = callback(
    GetCallbackQueryAnswer(
        chatId,
        messageId,
        payload
    )
)

/**
 * Sets the result of a callback query; for bots only
 *
 * @callbackQueryId - Identifier of the callback query
 * @text - Text of the answer
 * @showAlert - If true, an alert should be shown to the user instead of a toast notification
 * @url - URL to be opened
 * @cacheTime - Time during which the result of the query can be cached, in seconds
 */
suspend fun TelegramClient.answerCallbackQuery(
    callbackQueryId: Long,
    text: String,
    showAlert: Boolean,
    url: String,
    cacheTime: Int
): Ok = callback(
    AnswerCallbackQuery(
        callbackQueryId,
        text,
        showAlert,
        url,
        cacheTime
    )
)
