@file:Suppress("unused")

package dev.whyoleg.ktd.api.order

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns saved order info, if any
 */
suspend fun TelegramClient.order(
    f: GetSavedOrderInfo
): OrderInfo = execRaw(f) as OrderInfo

/**
 * Deletes saved order info
 */
suspend fun TelegramClient.order(
    f: DeleteSavedOrderInfo
): Ok = execRaw(f) as Ok
