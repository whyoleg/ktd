@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.chat

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a list of service actions taken by chat members and administrators in the last 48 hours
 * Available only in supergroups and channels
 * Requires administrator rights
 * Returns results in reverse chronological order (i
 * E., in order of decreasing event_id)
 *
 * @chatId - Chat identifier
 * @query - Search query by which to filter events
 * @fromEventId - Identifier of an event from which to return results
 *                Use 0 to get results from the latest events
 * @limit - Maximum number of events to return
 * @filters - The types of events to return
 *            By default, all types will be returned
 * @userIds - User identifiers by which to filter events
 *            By default, events relating to all users will be returned
 */
suspend fun TelegramClient.getChatEventLog(
    chatId: Long = 0L,
    query: String? = null,
    fromEventId: Long = 0L,
    limit: Int = 0,
    filters: ChatEventLogFilters? = null,
    userIds: IntArray = intArrayOf()
): ChatEvents = chat(
    GetChatEventLog(
        chatId,
        query,
        fromEventId,
        limit,
        filters,
        userIds
    )
)

/**
 * Returns a list of service actions taken by chat members and administrators in the last 48 hours
 * Available only in supergroups and channels
 * Requires administrator rights
 * Returns results in reverse chronological order (i
 * E., in order of decreasing event_id)
 */
suspend fun TelegramClient.chat(
    f: GetChatEventLog
): ChatEvents = exec(f) as ChatEvents
