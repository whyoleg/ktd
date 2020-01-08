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
 * Returns the received string
 * This is an offline method
 * Can be called before authorization
 *
 * @x - String to return
 */
@TestingOnly
suspend fun TelegramClient.testCallString(
    x: String? = null
): TestString = test(
    TestCallString(
        x
    )
)

/**
 * Returns the received string
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallString
): TestString = exec(f) as TestString
