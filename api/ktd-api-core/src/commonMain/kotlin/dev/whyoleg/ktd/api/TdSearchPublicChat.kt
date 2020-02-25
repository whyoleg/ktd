package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches a public chat by its username
 * Currently only private chats, supergroups and channels can be public
 * Returns the chat if found
 * Otherwise an error is returned
 *
 * @property username Username to be resolved
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchPublicChat")
data class TdSearchPublicChat(
    @SerialName("username")
    val username: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChat> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchPublicChat {
        return copy(extra = extra.copy(id = id))
    }
}
