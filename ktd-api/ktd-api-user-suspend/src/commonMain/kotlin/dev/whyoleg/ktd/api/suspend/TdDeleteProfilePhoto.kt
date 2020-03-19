package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Deletes a profile photo
 * If something changes, updateUser will be sent
 *
 * @property profilePhotoId Identifier of the profile photo to delete
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.deleteProfilePhoto(profilePhotoId: Long = 0L, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdDeleteProfilePhoto(profilePhotoId, extra))
