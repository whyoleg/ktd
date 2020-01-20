@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.can

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Stops the downloading of a file
 * If a file has already been downloaded, does nothing
 *
 * @fileId - Identifier of a file to stop downloading
 * @onlyIfPending - Pass true to stop downloading only if it hasn't been started, i.e
 *                  Request hasn't been sent to server
 */
suspend fun TelegramClient.cancelDownloadFile(
    fileId: Int = 0,
    onlyIfPending: Boolean = false
): Ok = can(
    CancelDownloadFile(
        fileId,
        onlyIfPending
    )
)

/**
 * Stops the downloading of a file
 * If a file has already been downloaded, does nothing
 */
suspend fun TelegramClient.can(
    f: CancelDownloadFile
): Ok = exec(f) as Ok
