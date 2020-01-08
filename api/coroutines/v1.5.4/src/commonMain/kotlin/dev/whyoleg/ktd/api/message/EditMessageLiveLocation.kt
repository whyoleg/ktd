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
 * Edits the message content of a live location
 * Messages can be edited for a limited period of time specified in the live location
 * Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup
 * @location - New location content of the message
 *             Pass null to stop sharing the live location
 */
suspend fun TelegramClient.editMessageLiveLocation(
    chatId: Long = 0L,
    messageId: Long = 0L,
    @BotsOnly replyMarkup: ReplyMarkup? = null,
    location: Location? = null
): Message = message(
    EditMessageLiveLocation(
        chatId,
        messageId,
        replyMarkup,
        location
    )
)

/**
 * Edits the message content of a live location
 * Messages can be edited for a limited period of time specified in the live location
 * Returns the edited message after the edit is completed on the server side
 */
suspend fun TelegramClient.message(
    f: EditMessageLiveLocation
): Message = exec(f) as Message
