package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the last message sent in a chat no later than the specified date
 *
 * @property chatId Chat identifier
 * @property date Point in time (Unix timestamp) relative to which to search for messages
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getChatMessageByDate")
data class TdGetChatMessageByDate(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("date")
    val date: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetChatMessageByDate {
        return copy(extra = extra.copy(id = id))
    }
}
