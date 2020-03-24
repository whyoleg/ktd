package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a private HTTPS link to a message in a chat
 * Available only for already sent messages in supergroups and channels
 * The link will work only for members of the chat
 *
 * @property chatId Identifier of the chat to which the message belongs
 * @property messageId Identifier of the message
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getMessageLink")
data class TdGetMessageLink(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdHttpUrl> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetMessageLink {
        return copy(extra = extra.copy(id = id))
    }
}
