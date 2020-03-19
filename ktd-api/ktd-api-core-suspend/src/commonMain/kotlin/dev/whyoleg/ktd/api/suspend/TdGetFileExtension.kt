package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the extension of a file, guessed by its MIME type
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 *
 * @property mimeType The MIME type of the file
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getFileExtension(mimeType: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdText = exec(TdGetFileExtension(mimeType, extra))
