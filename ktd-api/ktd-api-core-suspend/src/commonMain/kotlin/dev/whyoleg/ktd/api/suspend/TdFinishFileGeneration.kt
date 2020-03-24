package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Finishes the file generation
 *
 * @property generationId The identifier of the generation process
 * @property error If set, means that file generation has failed and should be terminated
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.finishFileGeneration(
    generationId: Long = 0L,
    error: TdError? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdFinishFileGeneration(generationId, error, extra))
