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
 * Removes a sticker from the list of recently used stickers
 *
 * @isAttached - Pass true to remove the sticker from the list of stickers recently attached to photo or video files
 *               Pass false to remove the sticker from the list of recently sent stickers
 * @sticker - Sticker file to delete
 */
suspend fun TelegramClient.removeRecentSticker(
    isAttached: Boolean = false,
    sticker: InputFile? = null
): Ok = sticker(
    RemoveRecentSticker(
        isAttached,
        sticker
    )
)

/**
 * Removes a sticker from the list of recently used stickers
 */
suspend fun TelegramClient.sticker(
    f: RemoveRecentSticker
): Ok = exec(f) as Ok
