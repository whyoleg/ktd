package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of frequently used chats
 * Supported only if the chat info database is enabled
 *
 * @property category Category of chats to be returned
 * @property limit The maximum number of chats to be returned
 *                 Up to 30
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getTopChats(
    category: TdTopChatCategory? = null,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdChats = exec(TdGetTopChats(category, limit, extra))
