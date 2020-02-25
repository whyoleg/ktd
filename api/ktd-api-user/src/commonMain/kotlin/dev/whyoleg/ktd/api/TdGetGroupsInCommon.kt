package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a list of common group chats with a given user
 * Chats are sorted by their type and creation date
 *
 * @property userId User identifier
 * @property offsetChatId Chat identifier starting from which to return chats
 *                        Use 0 for the first request
 * @property limit The maximum number of chats to be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getGroupsInCommon")
data class TdGetGroupsInCommon(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("offset_chat_id")
    val offsetChatId: Long = 0L,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChats> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetGroupsInCommon {
        return copy(extra = extra.copy(id = id))
    }
}
