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
 * Changes the draft message in a chat
 *
 * @chatId - Chat identifier
 * @draftMessage - New draft message
 */
suspend fun TelegramClient.setChatDraftMessage(
    chatId: Long = 0L,
    draftMessage: DraftMessage? = null
): Ok = chat(
    SetChatDraftMessage(
        chatId,
        draftMessage
    )
)

/**
 * Changes the draft message in a chat
 */
suspend fun TelegramClient.chat(
    f: SetChatDraftMessage
): Ok = exec(f) as Ok
