package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends the result of an inline query as a message
 * Returns the sent message
 * Always clears a chat draft message
 *
 * @property chatId Target chat
 * @property replyToMessageId Identifier of a message to reply to or 0
 * @property options Options to be used to send the message
 * @property queryId Identifier of the inline query
 * @property resultId Identifier of the inline result
 * @property hideViaBot If true, there will be no mention of a bot, via which the message is sent
 *                      Can be used only for bots GetOption("animation_search_bot_username"), GetOption("photo_search_bot_username") and GetOption("venue_search_bot_username")
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendInlineQueryResultMessage(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    options: TdSendMessageOptions? = null,
    queryId: Long = 0L,
    resultId: String? = null,
    hideViaBot: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdSendInlineQueryResultMessage(chatId, replyToMessageId, options, queryId,
        resultId, hideViaBot, extra))
