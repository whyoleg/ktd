package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

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
suspend fun SuspendTdClient.setPollAnswer(
    chatId: Long = 0L,
    messageId: Long = 0L,
    optionIds: IntArray = intArrayOf(),
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetPollAnswer(chatId, messageId, optionIds, extra))
