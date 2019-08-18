@file:Suppress("unused")

package dev.whyoleg.ktd.api.payment

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns an invoice payment form. This method should be called when the user presses inlineKeyboardButtonBuy
 *
 * @chatId - Chat identifier of the Invoice message
 * @messageId - Message identifier
 */
suspend fun TelegramClient.getPaymentForm(
    chatId: Long,
    messageId: Long
): PaymentForm = payment(
    GetPaymentForm(
        chatId,
        messageId
    )
)

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
    chatId: Long,
    messageId: Long,
    orderInfoId: String,
    shippingOptionId: String,
    credentials: InputCredentials
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
 * Returns information about a successful payment
 *
 * @chatId - Chat identifier of the PaymentSuccessful message
 * @messageId - Message identifier
 */
suspend fun TelegramClient.getPaymentReceipt(
    chatId: Long,
    messageId: Long
): PaymentReceipt = payment(
    GetPaymentReceipt(
        chatId,
        messageId
    )
)
