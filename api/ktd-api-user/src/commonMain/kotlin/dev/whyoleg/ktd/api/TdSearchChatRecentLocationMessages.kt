package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about the recent locations of chat members that were sent to the chat
 * Returns up to 1 location message per user
 *
 * @property chatId Chat identifier
 * @property limit The maximum number of messages to be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchChatRecentLocationMessages")
data class TdSearchChatRecentLocationMessages(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessages> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchChatRecentLocationMessages {
        return copy(extra = extra.copy(id = id))
    }
}
