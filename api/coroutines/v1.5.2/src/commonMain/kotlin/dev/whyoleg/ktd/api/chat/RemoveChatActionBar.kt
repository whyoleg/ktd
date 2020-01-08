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
 * Removes a chat action bar without any other action
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.removeChatActionBar(
    chatId: Long = 0L
): Ok = chat(
    RemoveChatActionBar(
        chatId
    )
)

/**
 * Removes a chat action bar without any other action
 */
suspend fun TelegramClient.chat(
    f: RemoveChatActionBar
): Ok = exec(f) as Ok
