@file:Suppress("unused")

package dev.whyoleg.ktd.api.seconds

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Computes time needed to receive a response from a Telegram server through a proxy. Can be called before authorization
 */
suspend fun TelegramClient.seconds(
    f: PingProxy
): Seconds = execRaw(f) as Seconds
