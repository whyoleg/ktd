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
 * Reads a part of a file from the TDLib file cache and returns read bytes
 * This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct read from the file
 *
 * @fileId - Identifier of the file
 *           The file must be located in the TDLib file cache
 * @offset - The offset from which to read the file
 * @count - Number of bytes to read
 *          An error will be returned if there are not enough bytes available in the file from the specified position
 *          Pass 0 to read all available data from the specified position
 */
suspend fun TelegramClient.readFilePart(
    fileId: Int = 0,
    offset: Int = 0,
    count: Int = 0
): FilePart = file(
    ReadFilePart(
        fileId,
        offset,
        count
    )
)

/**
 * Reads a part of a file from the TDLib file cache and returns read bytes
 * This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct read from the file
 */
suspend fun TelegramClient.file(
    f: ReadFilePart
): FilePart = exec(f) as FilePart
