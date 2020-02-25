package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the marked as unread state of a chat
 *
 * @property chatId Chat identifier
 * @property isMarkedAsUnread New value of is_marked_as_unread
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("toggleChatIsMarkedAsUnread")
data class TdToggleChatIsMarkedAsUnread(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("is_marked_as_unread")
    val isMarkedAsUnread: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdToggleChatIsMarkedAsUnread {
        return copy(extra = extra.copy(id = id))
    }
}
