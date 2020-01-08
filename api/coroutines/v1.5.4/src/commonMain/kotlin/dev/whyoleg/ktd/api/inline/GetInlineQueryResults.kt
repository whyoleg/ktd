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
 * Sends an inline query to a bot and returns its results
 * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 *
 * @botUserId - The identifier of the target bot
 * @chatId - Identifier of the chat where the query was sent
 * @userLocation - Location of the user, only if needed
 * @query - Text of the query
 * @offset - Offset of the first entry to return
 */
suspend fun TelegramClient.getInlineQueryResults(
    botUserId: Int = 0,
    chatId: Long = 0L,
    userLocation: Location? = null,
    query: String? = null,
    offset: String? = null
): InlineQueryResults = inline(
    GetInlineQueryResults(
        botUserId,
        chatId,
        userLocation,
        query,
        offset
    )
)

/**
 * Sends an inline query to a bot and returns its results
 * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 */
suspend fun TelegramClient.inline(
    f: GetInlineQueryResults
): InlineQueryResults = exec(f) as InlineQueryResults
