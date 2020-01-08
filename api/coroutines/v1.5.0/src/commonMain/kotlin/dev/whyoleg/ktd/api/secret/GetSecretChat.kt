@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.secret

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a secret chat by its identifier
 * This is an offline request
 *
 * @secretChatId - Secret chat identifier
 */
suspend fun TelegramClient.getSecretChat(
    secretChatId: Int = 0
): SecretChat = secret(
    GetSecretChat(
        secretChatId
    )
)

/**
 * Returns information about a secret chat by its identifier
 * This is an offline request
 */
suspend fun TelegramClient.secret(
    f: GetSecretChat
): SecretChat = exec(f) as SecretChat
