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
 * Removes a sticker from the set to which it belongs
 * The sticker set must have been created by the bot
 *
 * @sticker - Sticker
 */
@BotsOnly
suspend fun TelegramClient.removeStickerFromSet(
    sticker: InputFile? = null
): Ok = sticker(
    RemoveStickerFromSet(
        sticker
    )
)

/**
 * Removes a sticker from the set to which it belongs
 * The sticker set must have been created by the bot
 */
@BotsOnly
suspend fun TelegramClient.sticker(
    f: RemoveStickerFromSet
): Ok = exec(f) as Ok
