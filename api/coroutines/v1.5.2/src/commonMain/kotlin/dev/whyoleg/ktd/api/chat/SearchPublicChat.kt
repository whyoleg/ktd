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
 * Searches a public chat by its username
 * Currently only private chats, supergroups and channels can be public
 * Returns the chat if found
 * Otherwise an error is returned
 *
 * @username - Username to be resolved
 */
suspend fun TelegramClient.searchPublicChat(
    username: String? = null
): Chat = chat(
    SearchPublicChat(
        username
    )
)

/**
 * Searches a public chat by its username
 * Currently only private chats, supergroups and channels can be public
 * Returns the chat if found
 * Otherwise an error is returned
 */
suspend fun TelegramClient.chat(
    f: SearchPublicChat
): Chat = exec(f) as Chat
