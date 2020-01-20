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
 * Changes the discussion group of a channel chat
 * Requires can_change_info rights
 *
 * @chatId - Identifier of the channel chat
 * @discussionChatId - Identifier of a new channel's discussion group
 *                     Use 0 to remove the discussion group
 *                     If new chat members don't have access to old messages in the supergroup, then toggleSupergroupIsAllHistoryAvailable needs to be used first to change that
 */
suspend fun TelegramClient.setChatDiscussionGroup(
    chatId: Long = 0L,
    discussionChatId: Long = 0L
): Ok = chat(
    SetChatDiscussionGroup(
        chatId,
        discussionChatId
    )
)

/**
 * Changes the discussion group of a channel chat
 * Requires can_change_info rights
 */
suspend fun TelegramClient.chat(
    f: SetChatDiscussionGroup
): Ok = exec(f) as Ok
