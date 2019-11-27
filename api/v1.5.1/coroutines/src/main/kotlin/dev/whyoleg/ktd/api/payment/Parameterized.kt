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
 * Returns an invoice payment form
 * This method should be called when the user presses inlineKeyboardButtonBuy
 *
 * @chatId - Chat identifier of the Invoice message
 * @messageId - Message identifier
 */
suspend fun TelegramClient.getPaymentForm(
    chatId: Long = 0L,
    messageId: Long = 0L
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
 * Returns information about a successful payment
 *
 * @chatId - Chat identifier of the PaymentSuccessful message
 * @messageId - Message identifier
 */
suspend fun TelegramClient.getPaymentReceipt(
    chatId: Long = 0L,
    messageId: Long = 0L
): PaymentReceipt = payment(
    GetPaymentReceipt(
        chatId,
        messageId
    )
)

/**
 * Deletes saved credentials for all payment provider bots
 */
suspend fun TelegramClient.deleteSavedCredentials(): Ok = payment(
    DeleteSavedCredentials()
)
