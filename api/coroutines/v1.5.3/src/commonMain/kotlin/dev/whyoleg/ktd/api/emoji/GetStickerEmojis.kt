@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.emoji

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns emoji corresponding to a sticker
 * The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object
 *
 * @sticker - Sticker file identifier
 */
suspend fun TelegramClient.getStickerEmojis(
    sticker: InputFile? = null
): Emojis = emoji(
    GetStickerEmojis(
        sticker
    )
)

/**
 * Returns emoji corresponding to a sticker
 * The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object
 */
suspend fun TelegramClient.emoji(
    f: GetStickerEmojis
): Emojis = exec(f) as Emojis
