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
 * Returns the received vector of strings
 * This is an offline method
 * Can be called before authorization
 *
 * @x - Vector of strings to return
 */
@TestingOnly
suspend fun TelegramClient.testCallVectorString(
    x: Array<String> = emptyArray()
): TestVectorString = test(
    TestCallVectorString(
        x
    )
)

/**
 * Returns the received vector of strings
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallVectorString
): TestVectorString = exec(f) as TestVectorString
