package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Informs TDLib on a file generation progress
 *
 * @property generationId The identifier of the generation process
 * @property expectedSize Expected size of the generated file, in bytes
 *                        0 if unknown
 * @property localPrefixSize The number of bytes already generated
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setFileGenerationProgress(
    generationId: Long = 0L,
    expectedSize: Int = 0,
    localPrefixSize: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetFileGenerationProgress(generationId, expectedSize, localPrefixSize, extra))
