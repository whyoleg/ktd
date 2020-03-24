package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of common group chats with a given user
 * Chats are sorted by their type and creation date
 *
 * @property userId User identifier
 * @property offsetChatId Chat identifier starting from which to return chats
 *                        Use 0 for the first request
 * @property limit The maximum number of chats to be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getGroupsInCommon(
    userId: Int = 0,
    offsetChatId: Long = 0L,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdChats = exec(TdGetGroupsInCommon(userId, offsetChatId, limit, extra))
