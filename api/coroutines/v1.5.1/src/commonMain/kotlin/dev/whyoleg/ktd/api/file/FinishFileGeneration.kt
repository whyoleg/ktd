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
 * Finishes the file generation
 *
 * @generationId - The identifier of the generation process
 * @error - If set, means that file generation has failed and should be terminated
 */
suspend fun TelegramClient.finishFileGeneration(
    generationId: Long = 0L,
    error: Error? = null
): Ok = file(
    FinishFileGeneration(
        generationId,
        error
    )
)

/**
 * Finishes the file generation
 */
suspend fun TelegramClient.file(
    f: FinishFileGeneration
): Ok = exec(f) as Ok
