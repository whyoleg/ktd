package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Stops the downloading of a file
 * If a file has already been downloaded, does nothing
 *
 * @property fileId Identifier of a file to stop downloading
 * @property onlyIfPending Pass true to stop downloading only if it hasn't been started, i.e
 *                         Request hasn't been sent to server
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.cancelDownloadFile(
    fileId: Int = 0,
    onlyIfPending: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdCancelDownloadFile(fileId, onlyIfPending, extra))
