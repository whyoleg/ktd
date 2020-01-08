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
 * Informs the server that some trending sticker sets have been viewed by the user
 *
 * @stickerSetIds - Identifiers of viewed trending sticker sets
 */
suspend fun TelegramClient.viewTrendingStickerSets(
    stickerSetIds: LongArray = longArrayOf()
): Ok = sticker(
    ViewTrendingStickerSets(
        stickerSetIds
    )
)

/**
 * Informs the server that some trending sticker sets have been viewed by the user
 */
suspend fun TelegramClient.sticker(
    f: ViewTrendingStickerSets
): Ok = exec(f) as Ok
