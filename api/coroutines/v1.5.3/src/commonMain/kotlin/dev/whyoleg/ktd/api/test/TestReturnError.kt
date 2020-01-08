@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.test

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the specified error and ensures that the Error object is used
 * This is an offline method
 * Can be called before authorization
 *
 * @error - The error to be returned
 */
@TestingOnly
suspend fun TelegramClient.testReturnError(
    error: Error? = null
): Error = test(
    TestReturnError(
        error
    )
)

/**
 * Returns the specified error and ensures that the Error object is used
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestReturnError
): Error = exec(f) as Error
