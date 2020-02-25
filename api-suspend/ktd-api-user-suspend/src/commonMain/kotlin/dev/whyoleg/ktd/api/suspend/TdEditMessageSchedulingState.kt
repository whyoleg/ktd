package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits the time when a scheduled message will be sent
 * Scheduling state of all messages in the same album or forwarded together with the message will be also changed
 *
 * @property chatId The chat the message belongs to
 * @property messageId Identifier of the message
 * @property schedulingState The new message scheduling state
 *                           Pass null to send the message immediately
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editMessageSchedulingState(
    chatId: Long = 0L,
    messageId: Long = 0L,
    schedulingState: TdMessageSchedulingState? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdEditMessageSchedulingState(chatId, messageId, schedulingState, extra))
