package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes potentially dangerous characters from the name of a file
 * The encoding of the file name is supposed to be UTF-8
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 *
 * @property fileName File name or path to the file
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.cleanFileName(fileName: String? = null, extra: TdExtra = TdExtra.EMPTY):
        TdText = exec(TdCleanFileName(fileName, extra))
