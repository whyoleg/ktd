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
 * Sets the current network type
 * Can be called before authorization
 * Calling this method forces all network connections to reopen, mitigating the delay in switching between different networks, so it should be called whenever the network is changed, even if the network type remains the same
 * Network type is used to check whether the library can use the network at all and also for collecting detailed network data usage statistics
 *
 * @type - The new network type
 *         By default, networkTypeOther
 */
suspend fun TelegramClient.setNetworkType(
    type: NetworkType? = null
): Ok = network(
    SetNetworkType(
        type
    )
)

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
 * Resets all network data usage statistics to zero
 * Can be called before authorization
 */
suspend fun TelegramClient.resetNetworkStatistics(): Ok = network(
    ResetNetworkStatistics()
)
