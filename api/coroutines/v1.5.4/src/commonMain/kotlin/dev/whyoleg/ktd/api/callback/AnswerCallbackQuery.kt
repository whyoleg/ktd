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

/**
 * Sets the result of a callback query
 */
@BotsOnly
suspend fun TelegramClient.callback(
    f: AnswerCallbackQuery
): Ok = exec(f) as Ok
