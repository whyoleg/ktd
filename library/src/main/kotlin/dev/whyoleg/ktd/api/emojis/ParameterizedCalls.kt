@file:Suppress("unused")

package dev.whyoleg.ktd.api.emojis

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns emoji corresponding to a sticker. The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object
 *
 * @sticker - Sticker file identifier
 */
suspend fun TelegramClient.getStickerEmojis(
    sticker: InputFile
): Emojis = emojis(
    GetStickerEmojis(
        sticker
    )
)

/**
 * Searches for emojis by keywords. Supported only if the file database is enabled
 *
 * @text - Text to search for
 * @exactMatch - True, if only emojis, which exactly match text needs to be returned
 */
suspend fun TelegramClient.searchEmojis(
    text: String,
    exactMatch: Boolean
): Emojis = emojis(
    SearchEmojis(
        text,
        exactMatch
    )
)
