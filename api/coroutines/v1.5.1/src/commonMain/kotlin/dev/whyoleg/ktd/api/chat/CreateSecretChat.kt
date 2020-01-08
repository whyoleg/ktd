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
 * Returns an existing chat corresponding to a known secret chat
 *
 * @secretChatId - Secret chat identifier
 */
suspend fun TelegramClient.createSecretChat(
    secretChatId: Int = 0
): Chat = chat(
    CreateSecretChat(
        secretChatId
    )
)

/**
 * Returns an existing chat corresponding to a known secret chat
 */
suspend fun TelegramClient.chat(
    f: CreateSecretChat
): Chat = exec(f) as Chat
