package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Deletes the default reply markup from a chat
 * Must be called after a one-time keyboard or a ForceReply reply markup has been used
 * UpdateChatReplyMarkup will be sent if the reply markup will be changed
 *
 * @property chatId Chat identifier
 * @property messageId The message identifier of the used keyboard
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deleteChatReplyMarkup")
data class TdDeleteChatReplyMarkup(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDeleteChatReplyMarkup {
        return copy(extra = extra.copy(id = id))
    }
}
