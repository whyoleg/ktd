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
 * Forces an updates.getDifference call to the Telegram servers
 */
@TestingOnly
suspend fun TelegramClient.testGetDifference(): Ok = test(
    TestGetDifference()
)

/**
 * Forces an updates.getDifference call to the Telegram servers
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestGetDifference
): Ok = exec(f) as Ok
