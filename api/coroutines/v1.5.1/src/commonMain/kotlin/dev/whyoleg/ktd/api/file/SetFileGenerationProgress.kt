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
 * Informs TDLib on a file generation prograss
 *
 * @generationId - The identifier of the generation process
 * @expectedSize - Expected size of the generated file, in bytes
 *                 0 if unknown
 * @localPrefixSize - The number of bytes already generated
 */
suspend fun TelegramClient.setFileGenerationProgress(
    generationId: Long = 0L,
    expectedSize: Int = 0,
    localPrefixSize: Int = 0
): Ok = file(
    SetFileGenerationProgress(
        generationId,
        expectedSize,
        localPrefixSize
    )
)

/**
 * Informs TDLib on a file generation prograss
 */
suspend fun TelegramClient.file(
    f: SetFileGenerationProgress
): Ok = exec(f) as Ok
