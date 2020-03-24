package dev.whyoleg.ktd.api

import kotlinx.serialization.*

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
@Serializable
@SerialName("getChatEventLog")
data class TdGetChatEventLog(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("query")
    val query: String? = null,
    @SerialName("from_event_id")
    val fromEventId: Long = 0L,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("filters")
    val filters: TdChatEventLogFilters? = null,
    @SerialName("user_ids")
    val userIds: IntArray = intArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChatEvents> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetChatEventLog {
        return copy(extra = extra.copy(id = id))
    }
}
