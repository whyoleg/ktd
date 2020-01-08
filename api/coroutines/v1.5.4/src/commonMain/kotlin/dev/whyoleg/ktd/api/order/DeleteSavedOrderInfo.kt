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
 * Deletes saved order info
 */
suspend fun TelegramClient.deleteSavedOrderInfo(): Ok = order(
    DeleteSavedOrderInfo()
)

/**
 * Deletes saved order info
 */
suspend fun TelegramClient.order(
    f: DeleteSavedOrderInfo
): Ok = exec(f) as Ok
