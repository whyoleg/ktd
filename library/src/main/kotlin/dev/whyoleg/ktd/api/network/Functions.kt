@file:Suppress("unused")

package dev.whyoleg.ktd.api.network

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sets the current network type. Can be called before authorization. Calling this method forces all network connections to reopen, mitigating the delay in switching between different networks, so it should be called whenever the network is changed, even if the network type remains the same.
 * Network type is used to check whether the library can use the network at all and also for collecting detailed network data usage statistics
 */
suspend fun TelegramClient.network(
    f: SetNetworkType
): Ok = execRaw(f) as Ok

/**
 * Returns network data usage statistics. Can be called before authorization
 */
suspend fun TelegramClient.network(
    f: GetNetworkStatistics
): NetworkStatistics = execRaw(f) as NetworkStatistics

/**
 * Adds the specified data to data usage statistics. Can be called before authorization
 */
suspend fun TelegramClient.network(
    f: AddNetworkStatistics
): Ok = execRaw(f) as Ok

/**
 * Resets all network data usage statistics to zero. Can be called before authorization
 */
suspend fun TelegramClient.network(
    f: ResetNetworkStatistics
): Ok = execRaw(f) as Ok
