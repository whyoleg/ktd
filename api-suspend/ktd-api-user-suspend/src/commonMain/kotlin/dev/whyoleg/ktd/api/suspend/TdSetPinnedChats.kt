package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the order of pinned chats
 *
 * @property chatList Chat list in which to change the order of pinned chats
 * @property chatIds The new list of pinned chats
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setPinnedChats(
    chatList: TdChatList? = null,
    chatIds: LongArray = longArrayOf(),
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetPinnedChats(chatList, chatIds, extra))
