@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Deletes messages
 *
 * @chatId - Chat identifier
 * @messageIds - Identifiers of the messages to be deleted
 * @revoke - Pass true to try to delete messages for all chat members
 *           Always true for supergroups, channels and secret chats
 */
suspend fun TelegramClient.deleteMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    revoke: Boolean = false
): Ok = message(
    DeleteMessages(
        chatId,
        messageIds,
        revoke
    )
)

/**
 * Deletes messages
 */
suspend fun TelegramClient.message(
    f: DeleteMessages
): Ok = exec(f) as Ok
