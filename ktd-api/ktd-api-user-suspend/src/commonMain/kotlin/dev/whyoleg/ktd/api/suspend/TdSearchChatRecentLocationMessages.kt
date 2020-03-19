package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about the recent locations of chat members that were sent to the chat
 * Returns up to 1 location message per user
 *
 * @property chatId Chat identifier
 * @property limit The maximum number of messages to be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchChatRecentLocationMessages(
    chatId: Long = 0L,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdMessages = exec(TdSearchChatRecentLocationMessages(chatId, limit, extra))
