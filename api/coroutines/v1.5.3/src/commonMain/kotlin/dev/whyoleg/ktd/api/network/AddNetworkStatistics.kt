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
 * Adds the specified data to data usage statistics
 * Can be called before authorization
 *
 * @entry - The network statistics entry with the data to be added to statistics
 */
suspend fun TelegramClient.addNetworkStatistics(
    entry: NetworkStatisticsEntry? = null
): Ok = network(
    AddNetworkStatistics(
        entry
    )
)

/**
 * Adds the specified data to data usage statistics
 * Can be called before authorization
 */
suspend fun TelegramClient.network(
    f: AddNetworkStatistics
): Ok = exec(f) as Ok
