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
 * Returns the squared received number
 * This is an offline method
 * Can be called before authorization
 *
 * @x - Number to square
 */
@TestingOnly
suspend fun TelegramClient.testSquareInt(
    x: Int = 0
): TestInt = test(
    TestSquareInt(
        x
    )
)

/**
 * Returns the squared received number
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestSquareInt
): TestInt = exec(f) as TestInt
