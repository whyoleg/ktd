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
 * Sends a filled-out payment form to the bot for final verification
 *
 * @chatId - Chat identifier of the Invoice message
 * @messageId - Message identifier
 * @orderInfoId - Identifier returned by ValidateOrderInfo, or an empty string
 * @shippingOptionId - Identifier of a chosen shipping option, if applicable
 * @credentials - The credentials chosen by user for payment
 */
suspend fun TelegramClient.sendPaymentForm(
    chatId: Long = 0L,
    messageId: Long = 0L,
    orderInfoId: String? = null,
    shippingOptionId: String? = null,
    credentials: InputCredentials? = null
): PaymentResult = payment(
    SendPaymentForm(
        chatId,
        messageId,
        orderInfoId,
        shippingOptionId,
        credentials
    )
)

/**
 * Sends a filled-out payment form to the bot for final verification
 */
suspend fun TelegramClient.payment(
    f: SendPaymentForm
): PaymentResult = exec(f) as PaymentResult
