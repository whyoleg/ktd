package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Pins a message in a chat
 * Requires can_pin_messages rights
 *
 * @property chatId Identifier of the chat
 * @property messageId Identifier of the new pinned message
 * @property disableNotification True, if there should be no notification about the pinned message
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("pinChatMessage")
data class TdPinChatMessage(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("disable_notification")
    val disableNotification: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdPinChatMessage {
        return copy(extra = extra.copy(id = id))
    }
}
