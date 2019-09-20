@file:Suppress("unused")

package dev.whyoleg.ktd.api.emojis

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns emoji corresponding to a sticker. The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object
 */
suspend fun TelegramClient.emojis(
    f: GetStickerEmojis
): Emojis = execRaw(f) as Emojis

/**
 * Searches for emojis by keywords. Supported only if the file database is enabled
 */
suspend fun TelegramClient.emojis(
    f: SearchEmojis
): Emojis = execRaw(f) as Emojis
