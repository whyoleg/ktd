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
 * Returns a list of basic group and supergroup chats, which can be used as a discussion group for a channel
 * Basic group chats need to be first upgraded to supergroups before they can be set as a discussion group
 */
suspend fun TelegramClient.getSuitableDiscussionChats(): Chats = chat(
    GetSuitableDiscussionChats()
)

/**
 * Returns a list of basic group and supergroup chats, which can be used as a discussion group for a channel
 * Basic group chats need to be first upgraded to supergroups before they can be set as a discussion group
 */
suspend fun TelegramClient.chat(
    f: GetSuitableDiscussionChats
): Chats = exec(f) as Chats
