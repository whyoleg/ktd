package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the pinned state of a chat
 * You can pin up to GetOption("pinned_chat_count_max")/GetOption("pinned_archived_chat_count_max") non-secret chats and the same number of secret chats in the main/archive chat list
 *
 * @property chatId Chat identifier
 * @property isPinned New value of is_pinned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("toggleChatIsPinned")
data class TdToggleChatIsPinned(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("is_pinned")
    val isPinned: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdToggleChatIsPinned {
        return copy(extra = extra.copy(id = id))
    }
}
