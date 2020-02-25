package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a pinned chat message
 *
 * @property chatId Identifier of the chat the message belongs to
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getChatPinnedMessage")
data class TdGetChatPinnedMessage(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetChatPinnedMessage {
        return copy(extra = extra.copy(id = id))
    }
}
