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
 * Returns the received bytes
 * This is an offline method
 * Can be called before authorization
 *
 * @x - Bytes to return
 */
@TestingOnly
suspend fun TelegramClient.testCallBytes(
    x: ByteArray = byteArrayOf()
): TestBytes = test(
    TestCallBytes(
        x
    )
)

/**
 * Returns the received bytes
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallBytes
): TestBytes = exec(f) as TestBytes
