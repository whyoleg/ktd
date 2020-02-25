package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends an inline query to a bot and returns its results
 * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 *
 * @property botUserId The identifier of the target bot
 * @property chatId Identifier of the chat where the query was sent
 * @property userLocation Location of the user, only if needed
 * @property query Text of the query
 * @property offset Offset of the first entry to return
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getInlineQueryResults(
    botUserId: Int = 0,
    chatId: Long = 0L,
    userLocation: TdLocation? = null,
    query: String? = null,
    offset: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdInlineQueryResults = exec(TdGetInlineQueryResults(botUserId, chatId, userLocation, query,
        offset, extra))
