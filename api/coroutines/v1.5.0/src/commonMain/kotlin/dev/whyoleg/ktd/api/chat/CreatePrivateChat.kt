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
 * Returns an existing chat corresponding to a given user
 *
 * @userId - User identifier
 * @force - If true, the chat will be created without network request
 *          In this case all information about the chat except its type, title and photo can be incorrect
 */
suspend fun TelegramClient.createPrivateChat(
    userId: Int = 0,
    force: Boolean = false
): Chat = chat(
    CreatePrivateChat(
        userId,
        force
    )
)

/**
 * Returns an existing chat corresponding to a given user
 */
suspend fun TelegramClient.chat(
    f: CreatePrivateChat
): Chat = exec(f) as Chat
