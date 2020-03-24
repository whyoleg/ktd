package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of service actions taken by chat members and administrators in the last 48 hours
 * Available only for supergroups and channels
 * Requires administrator rights
 * Returns results in reverse chronological order (i
 * E., in order of decreasing event_id)
 *
 * @property chatId Chat identifier
 * @property query Search query by which to filter events
 * @property fromEventId Identifier of an event from which to return results
 *                       Use 0 to get results from the latest events
 * @property limit The maximum number of events to return
 * @property filters The types of events to return
 *                   By default, all types will be returned
 * @property userIds User identifiers by which to filter events
 *                   By default, events relating to all users will be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getChatEventLog(
    chatId: Long = 0L,
    query: String? = null,
    fromEventId: Long = 0L,
    limit: Int = 0,
    filters: TdChatEventLogFilters? = null,
    userIds: IntArray = intArrayOf(),
    extra: TdExtra = TdExtra.EMPTY
): TdChatEvents = exec(TdGetChatEventLog(chatId, query, fromEventId, limit, filters, userIds,
        extra))
