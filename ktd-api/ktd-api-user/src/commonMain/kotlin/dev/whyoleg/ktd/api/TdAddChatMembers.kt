package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds multiple new members to a chat
 * Currently this option is only available for supergroups and channels
 * This option can't be used to join a chat
 * Members can't be added to a channel if it has more than 200 members
 * Members will not be added until the chat state has been synchronized with the server
 *
 * @property chatId Chat identifier
 * @property userIds Identifiers of the users to be added to the chat
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("addChatMembers")
data class TdAddChatMembers(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("user_ids")
    val userIds: IntArray = intArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAddChatMembers {
        return copy(extra = extra.copy(id = id))
    }
}
