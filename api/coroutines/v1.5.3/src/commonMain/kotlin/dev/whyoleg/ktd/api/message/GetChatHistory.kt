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
 * Returns messages in a chat
 * The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id)
 * For optimal performance the number of returned messages is chosen by the library
 * This is an offline request if only_local is true
 *
 * @chatId - Chat identifier
 * @fromMessageId - Identifier of the message starting from which history must be fetched
 *                  Use 0 to get results from the last message
 * @offset - Specify 0 to get results from exactly the from_message_id or a negative offset up to 99 to get additionally some newer messages
 * @limit - The maximum number of messages to be returned
 *          Must be positive and can't be greater than 100
 *          If the offset is negative, the limit must be greater or equal to -offset
 *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @onlyLocal - If true, returns only messages that are available locally without sending network requests
 */
suspend fun TelegramClient.getChatHistory(
    chatId: Long = 0L,
    fromMessageId: Long = 0L,
    offset: Int = 0,
    limit: Int = 0,
    onlyLocal: Boolean = false
): Messages = message(
    GetChatHistory(
        chatId,
        fromMessageId,
        offset,
        limit,
        onlyLocal
    )
)

/**
 * Returns messages in a chat
 * The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id)
 * For optimal performance the number of returned messages is chosen by the library
 * This is an offline request if only_local is true
 */
suspend fun TelegramClient.message(
    f: GetChatHistory
): Messages = exec(f) as Messages
