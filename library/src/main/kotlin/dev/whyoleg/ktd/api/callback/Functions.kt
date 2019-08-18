@file:Suppress("unused")

package dev.whyoleg.ktd.api.callback

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sends a callback query to a bot and returns an answer. Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 */
suspend fun TelegramClient.callback(
    f: GetCallbackQueryAnswer
): CallbackQueryAnswer = execRaw(f) as CallbackQueryAnswer

/**
 * Sets the result of a callback query; for bots only
 */
suspend fun TelegramClient.callback(
    f: AnswerCallbackQuery
): Ok = execRaw(f) as Ok
