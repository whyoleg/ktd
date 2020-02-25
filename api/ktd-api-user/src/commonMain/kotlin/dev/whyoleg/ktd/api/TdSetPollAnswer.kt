package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the user answer to a poll
 * A poll in quiz mode can be answered only once
 *
 * @property chatId Identifier of the chat to which the poll belongs
 * @property messageId Identifier of the message containing the poll
 * @property optionIds 0-based identifiers of answer options, chosen by the user
 *                     User can choose more than 1 answer option only is the poll allows multiple answers
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setPollAnswer")
data class TdSetPollAnswer(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("option_ids")
    val optionIds: IntArray = intArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetPollAnswer {
        return copy(extra = extra.copy(id = id))
    }
}
