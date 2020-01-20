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
 * Clears the list of recently found chats
 */
suspend fun TelegramClient.clearRecentlyFoundChats(): Ok = chat(
    ClearRecentlyFoundChats()
)

/**
 * Clears the list of recently found chats
 */
suspend fun TelegramClient.chat(
    f: ClearRecentlyFoundChats
): Ok = exec(f) as Ok
