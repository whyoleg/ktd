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
 * Returns information about a file
 * This is an offline request
 *
 * @fileId - Identifier of the file to get
 */
suspend fun TelegramClient.getFile(
    fileId: Int = 0
): File = file(
    GetFile(
        fileId
    )
)

/**
 * Returns information about a file
 * This is an offline request
 */
suspend fun TelegramClient.file(
    f: GetFile
): File = exec(f) as File
