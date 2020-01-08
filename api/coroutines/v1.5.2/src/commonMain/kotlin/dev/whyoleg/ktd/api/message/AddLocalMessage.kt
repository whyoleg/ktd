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
 * Adds a local message to a chat
 * The message is persistent across application restarts only if the message database is used
 * Returns the added message
 *
 * @chatId - Target chat
 * @senderUserId - Identifier of the user who will be shown as the sender of the message
 *                 May be 0 for channel posts
 * @replyToMessageId - Identifier of the message to reply to or 0
 * @disableNotification - Pass true to disable notification for the message
 * @inputMessageContent - The content of the message to be added
 */
suspend fun TelegramClient.addLocalMessage(
    chatId: Long = 0L,
    senderUserId: Int = 0,
    replyToMessageId: Long = 0L,
    disableNotification: Boolean = false,
    inputMessageContent: InputMessageContent? = null
): Message = message(
    AddLocalMessage(
        chatId,
        senderUserId,
        replyToMessageId,
        disableNotification,
        inputMessageContent
    )
)

/**
 * Adds a local message to a chat
 * The message is persistent across application restarts only if the message database is used
 * Returns the added message
 */
suspend fun TelegramClient.message(
    f: AddLocalMessage
): Message = exec(f) as Message
