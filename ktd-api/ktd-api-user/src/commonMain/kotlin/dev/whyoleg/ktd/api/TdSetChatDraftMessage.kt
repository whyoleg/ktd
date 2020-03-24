package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the draft message in a chat
 *
 * @property chatId Chat identifier
 * @property draftMessage New draft message
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setChatDraftMessage")
data class TdSetChatDraftMessage(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("draft_message")
    val draftMessage: TdDraftMessage? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetChatDraftMessage {
        return copy(extra = extra.copy(id = id))
    }
}
