package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for call messages
 * Returns the results in reverse chronological order (i
 * E., in order of decreasing message_id)
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @property fromMessageId Identifier of the message from which to search
 *                         Use 0 to get results from the last message
 * @property limit The maximum number of messages to be returned
 *                 Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @property onlyMissed If true, returns only messages with missed calls
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchCallMessages")
data class TdSearchCallMessages(
    @SerialName("from_message_id")
    val fromMessageId: Long = 0L,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("only_missed")
    val onlyMissed: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessages> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchCallMessages {
        return copy(extra = extra.copy(id = id))
    }
}
