package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the owner of a chat
 * The current user must be a current owner of the chat
 * Use the method canTransferOwnership to check whether the ownership can be transferred from the current session
 * Available only for supergroups and channel chats
 *
 * @property chatId Chat identifier
 * @property userId Identifier of the user to which transfer the ownership
 *                  The ownership can't be transferred to a bot or to a deleted user
 * @property password The password of the current user
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("transferChatOwnership")
data class TdTransferChatOwnership(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("password")
    val password: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTransferChatOwnership {
        return copy(extra = extra.copy(id = id))
    }
}
