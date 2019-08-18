@file:Suppress("unused")

package dev.whyoleg.ktd.api.temporary

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Creates a new temporary password for processing payments
 */
suspend fun TelegramClient.temporary(
    f: CreateTemporaryPassword
): TemporaryPasswordState = execRaw(f) as TemporaryPasswordState

/**
 * Returns information about the current temporary password
 */
suspend fun TelegramClient.temporary(
    f: GetTemporaryPasswordState
): TemporaryPasswordState = execRaw(f) as TemporaryPasswordState
