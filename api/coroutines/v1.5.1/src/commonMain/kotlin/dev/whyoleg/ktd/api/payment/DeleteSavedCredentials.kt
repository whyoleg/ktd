@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.payment

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Deletes saved credentials for all payment provider bots
 */
suspend fun TelegramClient.deleteSavedCredentials(): Ok = payment(
    DeleteSavedCredentials()
)

/**
 * Deletes saved credentials for all payment provider bots
 */
suspend fun TelegramClient.payment(
    f: DeleteSavedCredentials
): Ok = exec(f) as Ok
