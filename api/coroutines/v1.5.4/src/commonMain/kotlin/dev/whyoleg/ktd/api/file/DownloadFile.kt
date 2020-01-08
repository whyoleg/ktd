@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.file

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Downloads a file from the cloud
 * Download progress and completion of the download will be notified through updateFile updates
 *
 * @fileId - Identifier of the file to download
 * @priority - Priority of the download (1-32)
 *             The higher the priority, the earlier the file will be downloaded
 *             If the priorities of two files are equal, then the last one for which downloadFile was called will be downloaded first
 * @offset - The starting position from which the file should be downloaded
 * @limit - Number of bytes which should be downloaded starting from the "offset" position before the download will be automatically cancelled
 *          Use 0 to download without a limit
 * @synchronous - If false, this request returns file state just after the download has been started
 *                If true, this request returns file state only after the download has succeeded, has failed, has been cancelled or a new downloadFile request with different offset/limit parameters was sent
 */
suspend fun TelegramClient.downloadFile(
    fileId: Int = 0,
    priority: Int = 0,
    offset: Int = 0,
    limit: Int = 0,
    synchronous: Boolean = false
): File = file(
    DownloadFile(
        fileId,
        priority,
        offset,
        limit,
        synchronous
    )
)

/**
 * Downloads a file from the cloud
 * Download progress and completion of the download will be notified through updateFile updates
 */
suspend fun TelegramClient.file(
    f: DownloadFile
): File = exec(f) as File
