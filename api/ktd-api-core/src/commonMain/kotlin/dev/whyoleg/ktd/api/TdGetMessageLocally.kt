package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a message, if it is available locally without sending network request
 * This is an offline request
 *
 * @property chatId Identifier of the chat the message belongs to
 * @property messageId Identifier of the message to get
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getMessageLocally")
data class TdGetMessageLocally(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetMessageLocally {
        return copy(extra = extra.copy(id = id))
    }
}
