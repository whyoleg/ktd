@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes the current TTL setting (sets a new self-destruct timer) in a secret chat and sends the corresponding message
 *
 * @chatId - Chat identifier
 * @ttl - New TTL value, in seconds
 */
suspend fun TelegramClient.sendChatSetTtlMessage(
    chatId: Long = 0L,
    ttl: Int = 0
): Message = message(
    SendChatSetTtlMessage(
        chatId,
        ttl
    )
)

/**
 * Changes the current TTL setting (sets a new self-destruct timer) in a secret chat and sends the corresponding message
 */
suspend fun TelegramClient.message(
    f: SendChatSetTtlMessage
): Message = exec(f) as Message
