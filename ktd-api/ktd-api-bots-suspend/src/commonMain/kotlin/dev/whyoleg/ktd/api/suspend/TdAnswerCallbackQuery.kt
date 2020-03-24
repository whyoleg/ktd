package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sets the result of a callback query
 *
 * @property callbackQueryId Identifier of the callback query
 * @property text Text of the answer
 * @property showAlert If true, an alert should be shown to the user instead of a toast notification
 * @property url URL to be opened
 * @property cacheTime Time during which the result of the query can be cached, in seconds
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.answerCallbackQuery(
    callbackQueryId: Long = 0L,
    text: String? = null,
    showAlert: Boolean = false,
    url: String? = null,
    cacheTime: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdAnswerCallbackQuery(callbackQueryId, text, showAlert, url, cacheTime, extra))
