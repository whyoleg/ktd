package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for call messages
 * Returns the results in reverse chronological order (i
 * E., in order of decreasing message_id)
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @property fromMessageId Identifier of the message from which to search
 *                         Use 0 to get results from the last message
 * @property limit The maximum number of messages to be returned
 *                 Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @property onlyMissed If true, returns only messages with missed calls
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchCallMessages(
    fromMessageId: Long = 0L,
    limit: Int = 0,
    onlyMissed: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdMessages = exec(TdSearchCallMessages(fromMessageId, limit, onlyMissed, extra))
