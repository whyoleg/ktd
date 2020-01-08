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
 * Returns a list of public chats of the specified type, owned by the user
 *
 * @type - Type of the public chats to return
 */
suspend fun TelegramClient.getCreatedPublicChats(
    type: PublicChatType? = null
): Chats = chat(
    GetCreatedPublicChats(
        type
    )
)

/**
 * Returns a list of public chats of the specified type, owned by the user
 */
suspend fun TelegramClient.chat(
    f: GetCreatedPublicChats
): Chats = exec(f) as Chats
