package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns users voted for the specified option in a non-anonymous polls
 * For the optimal performance the number of returned users is chosen by the library
 *
 * @property chatId Identifier of the chat to which the poll belongs
 * @property messageId Identifier of the message containing the poll
 * @property optionId 0-based identifier of the answer option
 * @property offset Number of users to skip in the result
 * @property limit The maximum number of users to be returned
 *                 Must be positive and can't be greater than 50
 *                 Fewer users may be returned than specified by the limit, even if the end of the voter list has not been reached
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getPollVoters")
data class TdGetPollVoters(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("option_id")
    val optionId: Int = 0,
    @SerialName("offset")
    val offset: Int = 0,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdUsers> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetPollVoters {
        return copy(extra = extra.copy(id = id))
    }
}
