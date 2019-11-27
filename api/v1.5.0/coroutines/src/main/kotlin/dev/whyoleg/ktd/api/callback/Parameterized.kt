@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.callback

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sends a callback query to a bot and returns an answer
 * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 *
 * @chatId - Identifier of the chat with the message
 * @messageId - Identifier of the message from which the query originated
 * @payload - Query payload
 */
suspend fun TelegramClient.getCallbackQueryAnswer(
    chatId: Long = 0L,
    messageId: Long = 0L,
    payload: CallbackQueryPayload? = null
): CallbackQueryAnswer = callback(
    GetCallbackQueryAnswer(
        chatId,
        messageId,
        payload
    )
)

/**
 * Sets the result of a callback query
 *
 * @callbackQueryId - Identifier of the callback query
 * @text - Text of the answer
 * @showAlert - If true, an alert should be shown to the user instead of a toast notification
 * @url - URL to be opened
 * @cacheTime - Time during which the result of the query can be cached, in seconds
 */
@BotsOnly
suspend fun TelegramClient.answerCallbackQuery(
    callbackQueryId: Long = 0L,
    text: String? = null,
    showAlert: Boolean = false,
    url: String? = null,
    cacheTime: Int = 0
): Ok = callback(
    AnswerCallbackQuery(
        callbackQueryId,
        text,
        showAlert,
        url,
        cacheTime
    )
)
