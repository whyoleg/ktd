@file:Suppress("unused")

package dev.whyoleg.ktd.api.payment

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns an invoice payment form. This method should be called when the user presses inlineKeyboardButtonBuy
 */
suspend fun TelegramClient.payment(
    f: GetPaymentForm
): PaymentForm = execRaw(f) as PaymentForm

/**
 * Sends a filled-out payment form to the bot for final verification
 */
suspend fun TelegramClient.payment(
    f: SendPaymentForm
): PaymentResult = execRaw(f) as PaymentResult

/**
 * Returns information about a successful payment
 */
suspend fun TelegramClient.payment(
    f: GetPaymentReceipt
): PaymentReceipt = execRaw(f) as PaymentReceipt
