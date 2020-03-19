package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

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
suspend fun SuspendTdClient.getPollVoters(
    chatId: Long = 0L,
    messageId: Long = 0L,
    optionId: Int = 0,
    offset: Int = 0,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdUsers = exec(TdGetPollVoters(chatId, messageId, optionId, offset, limit, extra))
