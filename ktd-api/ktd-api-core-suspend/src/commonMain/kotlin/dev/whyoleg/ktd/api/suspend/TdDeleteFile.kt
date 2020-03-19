package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Deletes a file from the TDLib file cache
 *
 * @property fileId Identifier of the file to delete
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.deleteFile(fileId: Int = 0, extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdDeleteFile(fileId, extra))
