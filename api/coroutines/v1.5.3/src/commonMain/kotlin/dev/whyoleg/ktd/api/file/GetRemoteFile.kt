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
 * Even the request succeeds, the file can be used only if it is still accessible to the user
 * For example, if the file is from a message, then the message must be not deleted and accessible to the user
 * If a file database is disabled, then the corresponding object with the file must be preloaded by the client
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
 * Even the request succeeds, the file can be used only if it is still accessible to the user
 * For example, if the file is from a message, then the message must be not deleted and accessible to the user
 * If a file database is disabled, then the corresponding object with the file must be preloaded by the client
 */
suspend fun TelegramClient.file(
    f: GetRemoteFile
): File = exec(f) as File
