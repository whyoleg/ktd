package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns file downloaded prefix size from a given offset
 *
 * @property fileId Identifier of the file
 * @property offset Offset from which downloaded prefix size should be calculated
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getFileDownloadedPrefixSize(
    fileId: Int = 0,
    offset: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdCount = exec(TdGetFileDownloadedPrefixSize(fileId, offset, extra))
