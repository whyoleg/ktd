@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.shipping

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sets the result of a shipping query
 *
 * @shippingQueryId - Identifier of the shipping query
 * @shippingOptions - Available shipping options
 * @errorMessage - An error message, empty on success
 */
@BotsOnly
suspend fun TelegramClient.answerShippingQuery(
    shippingQueryId: Long = 0L,
    shippingOptions: Array<ShippingOption> = emptyArray(),
    errorMessage: String? = null
): Ok = shipping(
    AnswerShippingQuery(
        shippingQueryId,
        shippingOptions,
        errorMessage
    )
)
