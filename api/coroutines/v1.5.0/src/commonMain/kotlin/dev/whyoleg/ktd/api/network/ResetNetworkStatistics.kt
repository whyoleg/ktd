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
 * Resets all network data usage statistics to zero
 * Can be called before authorization
 */
suspend fun TelegramClient.resetNetworkStatistics(): Ok = network(
    ResetNetworkStatistics()
)

/**
 * Resets all network data usage statistics to zero
 * Can be called before authorization
 */
suspend fun TelegramClient.network(
    f: ResetNetworkStatistics
): Ok = exec(f) as Ok
