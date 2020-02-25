package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches public chats by looking for specified query in their username and title
 * Currently only private chats, supergroups and channels can be public
 * Returns a meaningful number of results
 * Returns nothing if the length of the searched username prefix is less than 5
 * Excludes private chats with contacts and chats from the chat list from the results
 *
 * @property query Query to search for
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchPublicChats")
data class TdSearchPublicChats(
    @SerialName("query")
    val query: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChats> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchPublicChats {
        return copy(extra = extra.copy(id = id))
    }
}
