package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Uploads a new profile photo for the current user
 * If something changes, updateUser will be sent
 *
 * @property photo Profile photo to set
 *                 InputFileId and inputFileRemote may still be unsupported
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setProfilePhoto(photo: TdInputFile? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdSetProfilePhoto(photo, extra))
