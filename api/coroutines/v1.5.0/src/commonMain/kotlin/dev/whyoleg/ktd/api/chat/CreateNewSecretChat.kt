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
 * Creates a new secret chat
 * Returns the newly created chat
 *
 * @userId - Identifier of the target user
 */
suspend fun TelegramClient.createNewSecretChat(
    userId: Int = 0
): Chat = chat(
    CreateNewSecretChat(
        userId
    )
)

/**
 * Creates a new secret chat
 * Returns the newly created chat
 */
suspend fun TelegramClient.chat(
    f: CreateNewSecretChat
): Chat = exec(f) as Chat
