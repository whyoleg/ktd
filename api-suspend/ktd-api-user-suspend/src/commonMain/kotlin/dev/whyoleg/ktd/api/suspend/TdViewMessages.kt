package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Informs TDLib that messages are being viewed by the user
 * Many useful activities depend on whether the messages are currently being viewed or not (e.g., marking messages as read, incrementing a view counter, updating a view counter, removing deleted messages in supergroups and channels)
 *
 * @property chatId Chat identifier
 * @property messageIds The identifiers of the messages being viewed
 * @property forceRead True, if messages in closed chats should be marked as read
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.viewMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    forceRead: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdViewMessages(chatId, messageIds, forceRead, extra))
