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
 * Changes the position of a sticker in the set to which it belongs
 * The sticker set must have been created by the bot
 *
 * @sticker - Sticker
 * @position - New position of the sticker in the set, zero-based
 */
@BotsOnly
suspend fun TelegramClient.setStickerPositionInSet(
    sticker: InputFile? = null,
    position: Int = 0
): Ok = sticker(
    SetStickerPositionInSet(
        sticker,
        position
    )
)

/**
 * Changes the position of a sticker in the set to which it belongs
 * The sticker set must have been created by the bot
 */
@BotsOnly
suspend fun TelegramClient.sticker(
    f: SetStickerPositionInSet
): Ok = exec(f) as Ok
