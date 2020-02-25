package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Asynchronously uploads a file to the cloud without sending it in a message
 * UpdateFile will be used to notify about upload progress and successful completion of the upload
 * The file will not have a persistent remote identifier until it will be sent in a message
 *
 * @property file File to upload
 * @property fileType File type
 * @property priority Priority of the upload (1-32)
 *                    The higher the priority, the earlier the file will be uploaded
 *                    If the priorities of two files are equal, then the first one for which uploadFile was called will be uploaded first
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.uploadFile(
    file: TdInputFile? = null,
    fileType: TdFileType? = null,
    priority: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdFile = exec(TdUploadFile(file, fileType, priority, extra))
