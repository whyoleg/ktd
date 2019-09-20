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
 * Returns an HTTP URL which can be used to automatically log in to the translation platform and suggest new emoji replacements. The URL will be valid for 30 seconds after generation
 */
suspend fun TelegramClient.http(
    f: GetEmojiSuggestionsUrl
): HttpUrl = execRaw(f) as HttpUrl

/**
 * Constructs a persistent HTTP URL for a background
 */
suspend fun TelegramClient.http(
    f: GetBackgroundUrl
): HttpUrl = execRaw(f) as HttpUrl

/**
 * Returns an HTTP URL with the chat statistics. Currently this method can be used only for channels
 */
suspend fun TelegramClient.http(
    f: GetChatStatisticsUrl
): HttpUrl = execRaw(f) as HttpUrl
