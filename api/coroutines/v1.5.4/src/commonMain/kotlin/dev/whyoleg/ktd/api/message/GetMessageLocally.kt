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
 * Returns information about a message, if it is available locally without sending network request
 * This is an offline request
 *
 * @chatId - Identifier of the chat the message belongs to
 * @messageId - Identifier of the message to get
 */
suspend fun TelegramClient.getMessageLocally(
    chatId: Long = 0L,
    messageId: Long = 0L
): Message = message(
    GetMessageLocally(
        chatId,
        messageId
    )
)

/**
 * Returns information about a message, if it is available locally without sending network request
 * This is an offline request
 */
suspend fun TelegramClient.message(
    f: GetMessageLocally
): Message = exec(f) as Message
