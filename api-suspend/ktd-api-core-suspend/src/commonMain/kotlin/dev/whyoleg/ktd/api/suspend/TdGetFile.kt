package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a file
 * This is an offline request
 *
 * @property fileId Identifier of the file to get
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getFile(fileId: Int = 0, extra: TdExtra = TdExtra.EMPTY): TdFile =
        exec(TdGetFile(fileId, extra))
