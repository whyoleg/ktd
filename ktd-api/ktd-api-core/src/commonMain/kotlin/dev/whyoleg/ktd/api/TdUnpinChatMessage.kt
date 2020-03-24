package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes the pinned message from a chat
 * Requires can_pin_messages rights in the group or channel
 *
 * @property chatId Identifier of the chat
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("unpinChatMessage")
data class TdUnpinChatMessage(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdUnpinChatMessage {
        return copy(extra = extra.copy(id = id))
    }
}
