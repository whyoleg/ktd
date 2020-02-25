package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Writes a part of a generated file
 * This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct write to the destination file
 *
 * @property generationId The identifier of the generation process
 * @property offset The offset from which to write the data to the file
 * @property data The data to write
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.writeGeneratedFilePart(
    generationId: Long = 0L,
    offset: Int = 0,
    data: ByteArray = byteArrayOf(),
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdWriteGeneratedFilePart(generationId, offset, data, extra))
