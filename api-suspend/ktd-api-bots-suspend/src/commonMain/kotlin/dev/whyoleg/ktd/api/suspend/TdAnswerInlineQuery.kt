package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sets the result of an inline query
 *
 * @property inlineQueryId Identifier of the inline query
 * @property isPersonal True, if the result of the query can be cached for the specified user
 * @property results The results of the query
 * @property cacheTime Allowed time to cache the results of the query, in seconds
 * @property nextOffset Offset for the next inline query
 *                      Pass an empty string if there are no more results
 * @property switchPmText If non-empty, this text should be shown on the button that opens a private chat with the bot and sends a start message to the bot with the parameter switch_pm_parameter
 * @property switchPmParameter The parameter for the bot start message
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.answerInlineQuery(
    inlineQueryId: Long = 0L,
    isPersonal: Boolean = false,
    results: List<TdInputInlineQueryResult> = emptyList(),
    cacheTime: Int = 0,
    nextOffset: String? = null,
    switchPmText: String? = null,
    switchPmParameter: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdAnswerInlineQuery(inlineQueryId, isPersonal, results, cacheTime, nextOffset,
        switchPmText, switchPmParameter, extra))
