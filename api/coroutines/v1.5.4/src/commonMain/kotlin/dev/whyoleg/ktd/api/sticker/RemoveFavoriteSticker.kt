@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.sticker

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Removes a sticker from the list of favorite stickers
 *
 * @sticker - Sticker file to delete from the list
 */
suspend fun TelegramClient.removeFavoriteSticker(
    sticker: InputFile? = null
): Ok = sticker(
    RemoveFavoriteSticker(
        sticker
    )
)

/**
 * Removes a sticker from the list of favorite stickers
 */
suspend fun TelegramClient.sticker(
    f: RemoveFavoriteSticker
): Ok = exec(f) as Ok
