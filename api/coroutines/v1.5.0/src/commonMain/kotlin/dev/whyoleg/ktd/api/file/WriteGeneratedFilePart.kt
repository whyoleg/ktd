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
 * Writes a part of a generated file
 * This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct write to the destination file
 *
 * @generationId - The identifier of the generation process
 * @offset - The offset from which to write the data to the file
 * @data - The data to write
 */
suspend fun TelegramClient.writeGeneratedFilePart(
    generationId: Long = 0L,
    offset: Int = 0,
    data: ByteArray = byteArrayOf()
): Ok = file(
    WriteGeneratedFilePart(
        generationId,
        offset,
        data
    )
)

/**
 * Writes a part of a generated file
 * This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct write to the destination file
 */
suspend fun TelegramClient.file(
    f: WriteGeneratedFilePart
): Ok = exec(f) as Ok
