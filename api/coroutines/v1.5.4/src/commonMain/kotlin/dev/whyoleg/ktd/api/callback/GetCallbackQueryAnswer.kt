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
 * Sends a callback query to a bot and returns an answer
 * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 */
suspend fun TelegramClient.callback(
    f: GetCallbackQueryAnswer
): CallbackQueryAnswer = exec(f) as CallbackQueryAnswer
