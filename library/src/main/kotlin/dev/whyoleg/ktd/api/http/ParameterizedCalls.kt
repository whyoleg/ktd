@file:Suppress("unused")

package dev.whyoleg.ktd.api.http

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a private HTTPS link to a message in a chat. Available only for already sent messages in supergroups and channels. The link will work only for members of the chat
 *
 * @chatId - Identifier of the chat to which the message belongs
 * @messageId - Identifier of the message
 */
suspend fun TelegramClient.getMessageLink(
    chatId: Long,
    messageId: Long
): HttpUrl = http(
    GetMessageLink(
        chatId,
        messageId
    )
)

/**
 * Returns URL with the chat statistics. Currently this method can be used only for channels
 *
 * @chatId - Chat identifier
 * @parameters - Parameters from "tg:statsrefresh?params=******" link
 * @isDark - Pass true if a URL with the dark theme must be returned
 */
suspend fun TelegramClient.getChatStatisticsUrl(
    chatId: Long,
    parameters: String,
    isDark: Boolean
): HttpUrl = http(
    GetChatStatisticsUrl(
        chatId,
        parameters,
        isDark
    )
)
