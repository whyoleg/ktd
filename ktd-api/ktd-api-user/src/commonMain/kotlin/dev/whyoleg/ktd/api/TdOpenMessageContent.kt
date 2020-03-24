package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Informs TDLib that the message content has been opened (e.g., the user has opened a photo, video, document, location or venue, or has listened to an audio file or voice note message)
 * An updateMessageContentOpened update will be generated if something has changed
 *
 * @property chatId Chat identifier of the message
 * @property messageId Identifier of the message with the opened content
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("openMessageContent")
data class TdOpenMessageContent(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdOpenMessageContent {
        return copy(extra = extra.copy(id = id))
    }
}
