package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends a callback query to a bot and returns an answer
 * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 *
 * @property chatId Identifier of the chat with the message
 * @property messageId Identifier of the message from which the query originated
 * @property payload Query payload
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getCallbackQueryAnswer")
data class TdGetCallbackQueryAnswer(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("payload")
    val payload: TdCallbackQueryPayload? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdCallbackQueryAnswer> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetCallbackQueryAnswer {
        return copy(extra = extra.copy(id = id))
    }
}
