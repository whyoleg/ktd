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
 * Returns the received vector of objects containing a number
 * This is an offline method
 * Can be called before authorization
 *
 * @x - Vector of objects to return
 */
@TestingOnly
suspend fun TelegramClient.testCallVectorIntObject(
    x: Array<TestInt> = emptyArray()
): TestVectorIntObject = test(
    TestCallVectorIntObject(
        x
    )
)

/**
 * Returns the received vector of objects containing a number
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallVectorIntObject
): TestVectorIntObject = exec(f) as TestVectorIntObject
