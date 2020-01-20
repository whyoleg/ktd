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
 * Deletes a file from the TDLib file cache
 *
 * @fileId - Identifier of the file to delete
 */
suspend fun TelegramClient.deleteFile(
    fileId: Int = 0
): Ok = file(
    DeleteFile(
        fileId
    )
)

/**
 * Deletes a file from the TDLib file cache
 */
suspend fun TelegramClient.file(
    f: DeleteFile
): Ok = exec(f) as Ok
