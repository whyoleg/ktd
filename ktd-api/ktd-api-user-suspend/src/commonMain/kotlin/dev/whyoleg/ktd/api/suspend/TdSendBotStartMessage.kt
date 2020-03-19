package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Invites a bot to a chat (if it is not yet a member) and sends it the /start command
 * Bots can't be invited to a private chat other than the chat with the bot
 * Bots can't be invited to channels (although they can be added as admins) and secret chats
 * Returns the sent message
 *
 * @property botUserId Identifier of the bot
 * @property chatId Identifier of the target chat
 * @property parameter A hidden parameter sent to the bot for deep linking purposes (https://core.telegram.org/bots#deep-linking)
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendBotStartMessage(
    botUserId: Int = 0,
    chatId: Long = 0L,
    parameter: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdSendBotStartMessage(botUserId, chatId, parameter, extra))
