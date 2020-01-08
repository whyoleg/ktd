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
 * Returns an HTTP URL with the chat statistics
 * Currently this method can be used only for channels
 *
 * @chatId - Chat identifier
 * @parameters - Parameters from "tg://statsrefresh?params=******" link
 * @isDark - Pass true if a URL with the dark theme must be returned
 */
suspend fun TelegramClient.getChatStatisticsUrl(
    chatId: Long = 0L,
    parameters: String? = null,
    isDark: Boolean = false
): HttpUrl = chat(
    GetChatStatisticsUrl(
        chatId,
        parameters,
        isDark
    )
)

/**
 * Returns an HTTP URL with the chat statistics
 * Currently this method can be used only for channels
 */
suspend fun TelegramClient.chat(
    f: GetChatStatisticsUrl
): HttpUrl = exec(f) as HttpUrl
