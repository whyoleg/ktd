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
 * Closes a secret chat, effectively transfering its state to secretChatStateClosed
 *
 * @secretChatId - Secret chat identifier
 */
suspend fun TelegramClient.closeSecretChat(
    secretChatId: Int = 0
): Ok = secret(
    CloseSecretChat(
        secretChatId
    )
)

/**
 * Closes a secret chat, effectively transfering its state to secretChatStateClosed
 */
suspend fun TelegramClient.secret(
    f: CloseSecretChat
): Ok = exec(f) as Ok
