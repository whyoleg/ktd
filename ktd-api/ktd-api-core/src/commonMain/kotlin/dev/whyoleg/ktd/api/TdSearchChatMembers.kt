package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for a specified query in the first name, last name and username of the members of a specified chat
 * Requires administrator rights in channels
 *
 * @property chatId Chat identifier
 * @property query Query to search for
 * @property limit The maximum number of users to be returned
 * @property filter The type of users to return
 *                  By default, chatMembersFilterMembers
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchChatMembers")
data class TdSearchChatMembers(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("query")
    val query: String? = null,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("filter")
    val filter: TdChatMembersFilter? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChatMembers> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchChatMembers {
        return copy(extra = extra.copy(id = id))
    }
}
