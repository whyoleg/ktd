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
 * Returns information about a file by its remote ID
 * This is an offline request
 * Can be used to register a URL as a file for further uploading, or sending as a message
 *
 * @remoteFileId - Remote identifier of the file to get
 * @fileType - File type, if known
 */
suspend fun TelegramClient.getRemoteFile(
    remoteFileId: String? = null,
    fileType: FileType? = null
): File = file(
    GetRemoteFile(
        remoteFileId,
        fileType
    )
)

/**
 * Returns information about a file by its remote ID
 * This is an offline request
 * Can be used to register a URL as a file for further uploading, or sending as a message
 */
suspend fun TelegramClient.file(
    f: GetRemoteFile
): File = exec(f) as File
