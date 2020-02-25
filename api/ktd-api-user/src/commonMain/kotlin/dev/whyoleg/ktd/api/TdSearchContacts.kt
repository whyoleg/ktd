package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for the specified query in the first names, last names and usernames of the known user contacts
 *
 * @property query Query to search for
 *                 May be empty to return all contacts
 * @property limit The maximum number of users to be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchContacts")
data class TdSearchContacts(
    @SerialName("query")
    val query: String? = null,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdUsers> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchContacts {
        return copy(extra = extra.copy(id = id))
    }
}
