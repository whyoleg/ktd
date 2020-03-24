package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a list of basic group and supergroup chats, which can be used as a discussion group for a channel
 * Basic group chats need to be first upgraded to supergroups before they can be set as a discussion group
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getSuitableDiscussionChats")
data class TdGetSuitableDiscussionChats(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChats> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetSuitableDiscussionChats {
        return copy(extra = extra.copy(id = id))
    }
}
