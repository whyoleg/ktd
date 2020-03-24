package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Deletes messages
 *
 * @property chatId Chat identifier
 * @property messageIds Identifiers of the messages to be deleted
 * @property revoke Pass true to try to delete messages for all chat members
 *                  Always true for supergroups, channels and secret chats
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.deleteMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    revoke: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdDeleteMessages(chatId, messageIds, revoke, extra))
