@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.inline

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sets the result of an inline query
 *
 * @inlineQueryId - Identifier of the inline query
 * @isPersonal - True, if the result of the query can be cached for the specified user
 * @results - The results of the query
 * @cacheTime - Allowed time to cache the results of the query, in seconds
 * @nextOffset - Offset for the next inline query
 *               Pass an empty string if there are no more results
 * @switchPmText - If non-empty, this text should be shown on the button that opens a private chat with the bot and sends a start message to the bot with the parameter switch_pm_parameter
 * @switchPmParameter - The parameter for the bot start message
 */
@BotsOnly
suspend fun TelegramClient.answerInlineQuery(
    inlineQueryId: Long = 0L,
    isPersonal: Boolean = false,
    results: Array<InputInlineQueryResult> = emptyArray(),
    cacheTime: Int = 0,
    nextOffset: String? = null,
    switchPmText: String? = null,
    switchPmParameter: String? = null
): Ok = inline(
    AnswerInlineQuery(
        inlineQueryId,
        isPersonal,
        results,
        cacheTime,
        nextOffset,
        switchPmText,
        switchPmParameter
    )
)

/**
 * Sets the result of an inline query
 */
@BotsOnly
suspend fun TelegramClient.inline(
    f: AnswerInlineQuery
): Ok = exec(f) as Ok
