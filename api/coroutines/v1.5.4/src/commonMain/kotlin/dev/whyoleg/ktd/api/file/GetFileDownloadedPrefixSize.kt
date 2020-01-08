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
 * Returns file downloaded prefix size from a given offset
 *
 * @fileId - Identifier of the file
 * @offset - Offset from which downloaded prefix size should be calculated
 */
suspend fun TelegramClient.getFileDownloadedPrefixSize(
    fileId: Int = 0,
    offset: Int = 0
): Count = file(
    GetFileDownloadedPrefixSize(
        fileId,
        offset
    )
)

/**
 * Returns file downloaded prefix size from a given offset
 */
suspend fun TelegramClient.file(
    f: GetFileDownloadedPrefixSize
): Count = exec(f) as Count
