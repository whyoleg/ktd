package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Downloads a file from the cloud
 * Download progress and completion of the download will be notified through updateFile updates
 *
 * @property fileId Identifier of the file to download
 * @property priority Priority of the download (1-32)
 *                    The higher the priority, the earlier the file will be downloaded
 *                    If the priorities of two files are equal, then the last one for which downloadFile was called will be downloaded first
 * @property offset The starting position from which the file should be downloaded
 * @property limit Number of bytes which should be downloaded starting from the "offset" position before the download will be automatically cancelled
 *                 Use 0 to download without a limit
 * @property synchronous If false, this request returns file state just after the download has been started
 *                       If true, this request returns file state only after the download has succeeded, has failed, has been cancelled or a new downloadFile request with different offset/limit parameters was sent
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.downloadFile(
    fileId: Int = 0,
    priority: Int = 0,
    offset: Int = 0,
    limit: Int = 0,
    synchronous: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdFile = exec(TdDownloadFile(fileId, priority, offset, limit, synchronous, extra))
