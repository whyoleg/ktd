package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about messages
 * If a message is not found, returns null on the corresponding position of the result
 *
 * @property chatId Identifier of the chat the messages belong to
 * @property messageIds Identifiers of the messages to get
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getMessages")
data class TdGetMessages(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_ids")
    val messageIds: LongArray = longArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessages> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetMessages {
        return copy(extra = extra.copy(id = id))
    }
}
