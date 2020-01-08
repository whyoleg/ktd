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
 * Returns information about a public or private message link
 *
 * @url - The message link in the format "https://t.me/c/...", or "tg://privatepost?...", or "https://t.me/username/...", or "tg://resolve?..."
 */
suspend fun TelegramClient.getMessageLinkInfo(
    url: String? = null
): MessageLinkInfo = message(
    GetMessageLinkInfo(
        url
    )
)

/**
 * Returns information about a public or private message link
 */
suspend fun TelegramClient.message(
    f: GetMessageLinkInfo
): MessageLinkInfo = exec(f) as MessageLinkInfo
