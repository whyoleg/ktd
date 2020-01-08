@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.chat

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Adds multiple new members to a chat
 * Currently this option is only available for supergroups and channels
 * This option can't be used to join a chat
 * Members can't be added to a channel if it has more than 200 members
 * Members will not be added until the chat state has been synchronized with the server
 *
 * @chatId - Chat identifier
 * @userIds - Identifiers of the users to be added to the chat
 */
suspend fun TelegramClient.addChatMembers(
    chatId: Long = 0L,
    userIds: IntArray = intArrayOf()
): Ok = chat(
    AddChatMembers(
        chatId,
        userIds
    )
)

/**
 * Adds multiple new members to a chat
 * Currently this option is only available for supergroups and channels
 * This option can't be used to join a chat
 * Members can't be added to a channel if it has more than 200 members
 * Members will not be added until the chat state has been synchronized with the server
 */
suspend fun TelegramClient.chat(
    f: AddChatMembers
): Ok = exec(f) as Ok
