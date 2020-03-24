package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Installs/uninstalls or activates/archives a sticker set
 *
 * @property setId Identifier of the sticker set
 * @property isInstalled The new value of is_installed
 * @property isArchived The new value of is_archived
 *                      A sticker set can't be installed and archived simultaneously
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.changeStickerSet(
    setId: Long = 0L,
    isInstalled: Boolean = false,
    isArchived: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdChangeStickerSet(setId, isInstalled, isArchived, extra))
