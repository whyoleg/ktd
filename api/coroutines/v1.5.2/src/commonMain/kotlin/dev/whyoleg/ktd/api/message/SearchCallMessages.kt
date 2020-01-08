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
 * Searches for call messages
 * Returns the results in reverse chronological order (i
 * E., in order of decreasing message_id)
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @fromMessageId - Identifier of the message from which to search
 *                  Use 0 to get results from the last message
 * @limit - The maximum number of messages to be returned
 *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @onlyMissed - If true, returns only messages with missed calls
 */
suspend fun TelegramClient.searchCallMessages(
    fromMessageId: Long = 0L,
    limit: Int = 0,
    onlyMissed: Boolean = false
): Messages = message(
    SearchCallMessages(
        fromMessageId,
        limit,
        onlyMissed
    )
)

/**
 * Searches for call messages
 * Returns the results in reverse chronological order (i
 * E., in order of decreasing message_id)
 * For optimal performance the number of returned messages is chosen by the library
 */
suspend fun TelegramClient.message(
    f: SearchCallMessages
): Messages = exec(f) as Messages
