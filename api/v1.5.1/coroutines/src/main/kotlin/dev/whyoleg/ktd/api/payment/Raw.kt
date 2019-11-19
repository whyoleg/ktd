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
 */
suspend fun TelegramClient.payment(
    f: GetPaymentForm
): PaymentForm = exec(f) as PaymentForm

/**
 * Sends a filled-out payment form to the bot for final verification
 */
suspend fun TelegramClient.payment(
    f: SendPaymentForm
): PaymentResult = exec(f) as PaymentResult

/**
 * Returns information about a successful payment
 */
suspend fun TelegramClient.payment(
    f: GetPaymentReceipt
): PaymentReceipt = exec(f) as PaymentReceipt

/**
 * Deletes saved credentials for all payment provider bots
 */
suspend fun TelegramClient.payment(
    f: DeleteSavedCredentials
): Ok = exec(f) as Ok