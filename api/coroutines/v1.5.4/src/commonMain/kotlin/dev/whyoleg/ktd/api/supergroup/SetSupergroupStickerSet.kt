@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.supergroup

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes the sticker set of a supergroup
 * Requires can_change_info rights
 *
 * @supergroupId - Identifier of the supergroup
 * @stickerSetId - New value of the supergroup sticker set identifier
 *                 Use 0 to remove the supergroup sticker set
 */
suspend fun TelegramClient.setSupergroupStickerSet(
    supergroupId: Int = 0,
    stickerSetId: Long = 0L
): Ok = supergroup(
    SetSupergroupStickerSet(
        supergroupId,
        stickerSetId
    )
)

/**
 * Changes the sticker set of a supergroup
 * Requires can_change_info rights
 */
suspend fun TelegramClient.supergroup(
    f: SetSupergroupStickerSet
): Ok = exec(f) as Ok
