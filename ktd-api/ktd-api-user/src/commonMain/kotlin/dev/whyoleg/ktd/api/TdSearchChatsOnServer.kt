package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for the specified query in the title and username of already known chats via request to the server
 * Returns chats in the order seen in the chat list
 *
 * @property query Query to search for
 * @property limit The maximum number of chats to be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchChatsOnServer")
data class TdSearchChatsOnServer(
    @SerialName("query")
    val query: String? = null,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChats> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchChatsOnServer {
        return copy(extra = extra.copy(id = id))
    }
}
