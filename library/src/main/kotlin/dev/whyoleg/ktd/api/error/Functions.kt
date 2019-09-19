@file:Suppress("unused")

package dev.whyoleg.ktd.api.error

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the specified error and ensures that the Error object is used; for testing only. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.error(
    f: TestReturnError
): Error = execRaw(f) as Error
