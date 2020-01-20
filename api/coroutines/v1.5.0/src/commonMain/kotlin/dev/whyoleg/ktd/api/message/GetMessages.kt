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
 * Returns information about messages
 * If a message is not found, returns null on the corresponding position of the result
 *
 * @chatId - Identifier of the chat the messages belong to
 * @messageIds - Identifiers of the messages to get
 */
suspend fun TelegramClient.getMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf()
): Messages = message(
    GetMessages(
        chatId,
        messageIds
    )
)

/**
 * Returns information about messages
 * If a message is not found, returns null on the corresponding position of the result
 */
suspend fun TelegramClient.message(
    f: GetMessages
): Messages = exec(f) as Messages
