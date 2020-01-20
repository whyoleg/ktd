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
 * Changes client data associated with a chat
 *
 * @chatId - Chat identifier
 * @clientData - New value of client_data
 */
suspend fun TelegramClient.setChatClientData(
    chatId: Long = 0L,
    clientData: String? = null
): Ok = chat(
    SetChatClientData(
        chatId,
        clientData
    )
)

/**
 * Changes client data associated with a chat
 */
suspend fun TelegramClient.chat(
    f: SetChatClientData
): Ok = exec(f) as Ok
