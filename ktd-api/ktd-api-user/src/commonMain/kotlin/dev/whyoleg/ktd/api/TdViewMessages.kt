package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Informs TDLib that messages are being viewed by the user
 * Many useful activities depend on whether the messages are currently being viewed or not (e.g., marking messages as read, incrementing a view counter, updating a view counter, removing deleted messages in supergroups and channels)
 *
 * @property chatId Chat identifier
 * @property messageIds The identifiers of the messages being viewed
 * @property forceRead True, if messages in closed chats should be marked as read
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("viewMessages")
data class TdViewMessages(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_ids")
    val messageIds: LongArray = longArrayOf(),
    @SerialName("force_read")
    val forceRead: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdViewMessages {
        return copy(extra = extra.copy(id = id))
    }
}
