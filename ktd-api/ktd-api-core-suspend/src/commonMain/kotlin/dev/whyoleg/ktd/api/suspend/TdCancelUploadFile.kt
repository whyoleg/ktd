package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Stops the uploading of a file
 * Supported only for files uploaded by using uploadFile
 * For other files the behavior is undefined
 *
 * @property fileId Identifier of the file to stop uploading
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.cancelUploadFile(fileId: Int = 0, extra: TdExtra = TdExtra.EMPTY): TdOk
        = exec(TdCancelUploadFile(fileId, extra))
