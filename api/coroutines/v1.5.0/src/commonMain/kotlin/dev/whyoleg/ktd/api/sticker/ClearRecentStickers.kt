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
 * Clears the list of recently used stickers
 *
 * @isAttached - Pass true to clear the list of stickers recently attached to photo or video files
 *               Pass false to clear the list of recently sent stickers
 */
suspend fun TelegramClient.clearRecentStickers(
    isAttached: Boolean = false
): Ok = sticker(
    ClearRecentStickers(
        isAttached
    )
)

/**
 * Clears the list of recently used stickers
 */
suspend fun TelegramClient.sticker(
    f: ClearRecentStickers
): Ok = exec(f) as Ok
