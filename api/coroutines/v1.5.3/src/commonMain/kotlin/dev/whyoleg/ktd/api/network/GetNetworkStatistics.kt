@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.network

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns network data usage statistics
 * Can be called before authorization
 *
 * @onlyCurrent - If true, returns only data for the current library launch
 */
suspend fun TelegramClient.getNetworkStatistics(
    onlyCurrent: Boolean = false
): NetworkStatistics = network(
    GetNetworkStatistics(
        onlyCurrent
    )
)

/**
 * Returns network data usage statistics
 * Can be called before authorization
 */
suspend fun TelegramClient.network(
    f: GetNetworkStatistics
): NetworkStatistics = exec(f) as NetworkStatistics
