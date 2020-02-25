package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the position of a sticker in the set to which it belongs
 * The sticker set must have been created by the bot
 *
 * @property sticker Sticker
 * @property position New position of the sticker in the set, zero-based
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setStickerPositionInSet(
    sticker: TdInputFile? = null,
    position: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetStickerPositionInSet(sticker, position, extra))
