@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.validated

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Validates the order information provided by a user and returns the available shipping options for a flexible invoice
 */
suspend fun TelegramClient.validated(
    f: ValidateOrderInfo
): ValidatedOrderInfo = exec(f) as ValidatedOrderInfo
