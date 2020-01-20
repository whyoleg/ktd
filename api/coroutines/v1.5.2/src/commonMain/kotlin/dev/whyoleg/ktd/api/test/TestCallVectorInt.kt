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
 * Returns the received vector of numbers
 * This is an offline method
 * Can be called before authorization
 *
 * @x - Vector of numbers to return
 */
@TestingOnly
suspend fun TelegramClient.testCallVectorInt(
    x: IntArray = intArrayOf()
): TestVectorInt = test(
    TestCallVectorInt(
        x
    )
)

/**
 * Returns the received vector of numbers
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallVectorInt
): TestVectorInt = exec(f) as TestVectorInt
