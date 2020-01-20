@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Edits the time when a scheduled message will be sent
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @schedulingState - The new message scheduling state
 *                    Pass null to send the message immediately
 */
suspend fun TelegramClient.editMessageSchedulingState(
    chatId: Long = 0L,
    messageId: Long = 0L,
    schedulingState: MessageSchedulingState? = null
): Ok = message(
    EditMessageSchedulingState(
        chatId,
        messageId,
        schedulingState
    )
)

/**
 * Edits the time when a scheduled message will be sent
 */
suspend fun TelegramClient.message(
    f: EditMessageSchedulingState
): Ok = exec(f) as Ok
