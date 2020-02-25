package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds a local message to a chat
 * The message is persistent across application restarts only if the message database is used
 * Returns the added message
 *
 * @property chatId Target chat
 * @property senderUserId Identifier of the user who will be shown as the sender of the message
 *                        May be 0 for channel posts
 * @property replyToMessageId Identifier of the message to reply to or 0
 * @property disableNotification Pass true to disable notification for the message
 * @property inputMessageContent The content of the message to be added
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.addLocalMessage(
    chatId: Long = 0L,
    senderUserId: Int = 0,
    replyToMessageId: Long = 0L,
    disableNotification: Boolean = false,
    inputMessageContent: TdInputMessageContent? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdAddLocalMessage(chatId, senderUserId, replyToMessageId, disableNotification,
        inputMessageContent, extra))
