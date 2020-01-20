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
 * Returns the received vector of objects containing a string
 * This is an offline method
 * Can be called before authorization
 *
 * @x - Vector of objects to return
 */
@TestingOnly
suspend fun TelegramClient.testCallVectorStringObject(
    x: Array<TestString> = emptyArray()
): TestVectorStringObject = test(
    TestCallVectorStringObject(
        x
    )
)

/**
 * Returns the received vector of objects containing a string
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallVectorStringObject
): TestVectorStringObject = exec(f) as TestVectorStringObject
