package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Moves a chat to a different chat list
 * Current chat list of the chat must ne non-null
 *
 * @property chatId Chat identifier
 * @property chatList New chat list of the chat
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setChatChatList(
    chatId: Long = 0L,
    chatList: TdChatList? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetChatChatList(chatId, chatList, extra))
