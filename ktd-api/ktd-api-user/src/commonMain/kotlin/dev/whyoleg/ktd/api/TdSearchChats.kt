package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for the specified query in the title and username of already known chats, this is an offline request
 * Returns chats in the order seen in the chat list
 *
 * @property query Query to search for
 *                 If the query is empty, returns up to 20 recently found chats
 * @property limit The maximum number of chats to be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchChats")
data class TdSearchChats(
    @SerialName("query")
    val query: String? = null,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChats> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchChats {
        return copy(extra = extra.copy(id = id))
    }
}
