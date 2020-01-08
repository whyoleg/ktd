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
 * Changes the order of pinned chats
 *
 * @chatIds - The new list of pinned chats
 */
suspend fun TelegramClient.setPinnedChats(
    chatIds: LongArray = longArrayOf()
): Ok = chat(
    SetPinnedChats(
        chatIds
    )
)

/**
 * Changes the order of pinned chats
 */
suspend fun TelegramClient.chat(
    f: SetPinnedChats
): Ok = exec(f) as Ok
