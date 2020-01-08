@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.order

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns saved order info, if any
 */
suspend fun TelegramClient.getSavedOrderInfo(): OrderInfo = order(
    GetSavedOrderInfo()
)

/**
 * Returns saved order info, if any
 */
suspend fun TelegramClient.order(
    f: GetSavedOrderInfo
): OrderInfo = exec(f) as OrderInfo
