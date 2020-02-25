package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the MIME type of a file, guessed by its extension
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 *
 * @property fileName The name of the file or path to the file
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getFileMimeType(fileName: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdText = exec(TdGetFileMimeType(fileName, extra))
