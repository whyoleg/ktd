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
 * Returns a list of recently inactive supergroups and channels
 * Can be used when user reaches limit on the number of joined supergroups and channels and receives CHANNELS_TOO_MUCH error
 */
suspend fun TelegramClient.getInactiveSupergroupChats(): Chats = chat(
    GetInactiveSupergroupChats()
)

/**
 * Returns a list of recently inactive supergroups and channels
 * Can be used when user reaches limit on the number of joined supergroups and channels and receives CHANNELS_TOO_MUCH error
 */
suspend fun TelegramClient.chat(
    f: GetInactiveSupergroupChats
): Chats = exec(f) as Chats
