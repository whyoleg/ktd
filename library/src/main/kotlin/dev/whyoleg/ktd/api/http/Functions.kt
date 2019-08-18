@file:Suppress("unused")

package dev.whyoleg.ktd.api.http

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a private HTTPS link to a message in a chat. Available only for already sent messages in supergroups and channels. The link will work only for members of the chat
 */
suspend fun TelegramClient.http(
    f: GetMessageLink
): HttpUrl = execRaw(f) as HttpUrl

/**
 * Returns URL with the chat statistics. Currently this method can be used only for channels
 */
suspend fun TelegramClient.http(
    f: GetChatStatisticsUrl
): HttpUrl = execRaw(f) as HttpUrl
