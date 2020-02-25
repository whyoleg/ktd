package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds multiple new members to a chat
 * Currently this option is only available for supergroups and channels
 * This option can't be used to join a chat
 * Members can't be added to a channel if it has more than 200 members
 * Members will not be added until the chat state has been synchronized with the server
 *
 * @property chatId Chat identifier
 * @property userIds Identifiers of the users to be added to the chat
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.addChatMembers(
    chatId: Long = 0L,
    userIds: IntArray = intArrayOf(),
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdAddChatMembers(chatId, userIds, extra))
