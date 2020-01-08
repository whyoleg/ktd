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
 * Invites a bot to a chat (if it is not yet a member) and sends it the /start command
 * Bots can't be invited to a private chat other than the chat with the bot
 * Bots can't be invited to channels (although they can be added as admins) and secret chats
 * Returns the sent message
 *
 * @botUserId - Identifier of the bot
 * @chatId - Identifier of the target chat
 * @parameter - A hidden parameter sent to the bot for deep linking purposes (https://core.telegram.org/bots#deep-linking)
 */
suspend fun TelegramClient.sendBotStartMessage(
    botUserId: Int = 0,
    chatId: Long = 0L,
    parameter: String? = null
): Message = message(
    SendBotStartMessage(
        botUserId,
        chatId,
        parameter
    )
)

/**
 * Invites a bot to a chat (if it is not yet a member) and sends it the /start command
 * Bots can't be invited to a private chat other than the chat with the bot
 * Bots can't be invited to channels (although they can be added as admins) and secret chats
 * Returns the sent message
 */
suspend fun TelegramClient.message(
    f: SendBotStartMessage
): Message = exec(f) as Message
