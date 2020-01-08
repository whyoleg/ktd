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
 * Deletes the default reply markup from a chat
 * Must be called after a one-time keyboard or a ForceReply reply markup has been used
 * UpdateChatReplyMarkup will be sent if the reply markup will be changed
 *
 * @chatId - Chat identifier
 * @messageId - The message identifier of the used keyboard
 */
suspend fun TelegramClient.deleteChatReplyMarkup(
    chatId: Long = 0L,
    messageId: Long = 0L
): Ok = chat(
    DeleteChatReplyMarkup(
        chatId,
        messageId
    )
)

/**
 * Deletes the default reply markup from a chat
 * Must be called after a one-time keyboard or a ForceReply reply markup has been used
 * UpdateChatReplyMarkup will be sent if the reply markup will be changed
 */
suspend fun TelegramClient.chat(
    f: DeleteChatReplyMarkup
): Ok = exec(f) as Ok
