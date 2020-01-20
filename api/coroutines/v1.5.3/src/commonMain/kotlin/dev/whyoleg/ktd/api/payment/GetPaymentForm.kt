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
 * Returns an invoice payment form
 * This method should be called when the user presses inlineKeyboardButtonBuy
 */
suspend fun TelegramClient.payment(
    f: GetPaymentForm
): PaymentForm = exec(f) as PaymentForm
