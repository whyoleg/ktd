package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the sticker set of a supergroup
 * Requires can_change_info rights
 *
 * @property supergroupId Identifier of the supergroup
 * @property stickerSetId New value of the supergroup sticker set identifier
 *                        Use 0 to remove the supergroup sticker set
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setSupergroupStickerSet(
    supergroupId: Int = 0,
    stickerSetId: Long = 0L,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetSupergroupStickerSet(supergroupId, stickerSetId, extra))
