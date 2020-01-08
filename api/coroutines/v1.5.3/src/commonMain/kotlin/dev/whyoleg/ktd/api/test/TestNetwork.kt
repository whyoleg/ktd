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
 * Sends a simple network request to the Telegram servers
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.testNetwork(): Ok = test(
    TestNetwork()
)

/**
 * Sends a simple network request to the Telegram servers
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestNetwork
): Ok = exec(f) as Ok
