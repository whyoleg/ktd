package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes a chat from the list of frequently used chats
 * Supported only if the chat info database is enabled
 *
 * @property category Category of frequently used chats
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeTopChat(
    category: TdTopChatCategory? = null,
    chatId: Long = 0L,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdRemoveTopChat(category, chatId, extra))
