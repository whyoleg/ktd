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
 * Returns a list of public chats with username created by the user
 */
suspend fun TelegramClient.getCreatedPublicChats(): Chats = chat(
    GetCreatedPublicChats()
)

/**
 * Returns a list of public chats with username created by the user
 */
suspend fun TelegramClient.chat(
    f: GetCreatedPublicChats
): Chats = exec(f) as Chats
