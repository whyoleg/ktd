package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Edits the message content of a live location
 * Messages can be edited for a limited period of time specified in the live location
 * Returns the edited message after the edit is completed on the server side
 *
 * @property chatId The chat the message belongs to
 * @property messageId Identifier of the message
 * @property replyMarkup The new message reply markup
 * @property location New location content of the message
 *                    Pass null to stop sharing the live location
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("editMessageLiveLocation")
data class TdEditMessageLiveLocation(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("location")
    val location: TdLocation? = null,
    @SerialName("reply_markup")
    @TdBotsOnly
    val replyMarkup: TdReplyMarkup? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEditMessageLiveLocation {
        return copy(extra = extra.copy(id = id))
    }
}
