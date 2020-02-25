package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds current user as a new member to a chat
 * Private and secret chats can't be joined using this method
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("joinChat")
data class TdJoinChat(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdJoinChat {
        return copy(extra = extra.copy(id = id))
    }
}
