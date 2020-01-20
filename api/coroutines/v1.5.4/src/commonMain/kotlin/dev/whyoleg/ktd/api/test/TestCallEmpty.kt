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
 * Does nothing
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.testCallEmpty(): Ok = test(
    TestCallEmpty()
)

/**
 * Does nothing
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallEmpty
): Ok = exec(f) as Ok
