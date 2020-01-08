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
 * Installs/uninstalls or activates/archives a sticker set
 *
 * @setId - Identifier of the sticker set
 * @isInstalled - The new value of is_installed
 * @isArchived - The new value of is_archived
 *               A sticker set can't be installed and archived simultaneously
 */
suspend fun TelegramClient.changeStickerSet(
    setId: Long = 0L,
    isInstalled: Boolean = false,
    isArchived: Boolean = false
): Ok = sticker(
    ChangeStickerSet(
        setId,
        isInstalled,
        isArchived
    )
)

/**
 * Installs/uninstalls or activates/archives a sticker set
 */
suspend fun TelegramClient.sticker(
    f: ChangeStickerSet
): Ok = exec(f) as Ok
