@file:Suppress("unused")

package dev.whyoleg.ktd.api.secret

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a secret chat by its identifier. This is an offline request
 *
 * @secretChatId - Secret chat identifier
 */
suspend fun TelegramClient.getSecretChat(
    secretChatId: Int
): SecretChat = secret(
    GetSecretChat(
        secretChatId
    )
)

/**
 * Closes a secret chat, effectively transfering its state to secretChatStateClosed
 *
 * @secretChatId - Secret chat identifier
 */
suspend fun TelegramClient.closeSecretChat(
    secretChatId: Int
): Ok = secret(
    CloseSecretChat(
        secretChatId
    )
)
