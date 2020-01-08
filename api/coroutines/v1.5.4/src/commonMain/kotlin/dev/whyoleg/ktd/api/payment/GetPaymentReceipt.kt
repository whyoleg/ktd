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
 * Returns information about a successful payment
 */
suspend fun TelegramClient.payment(
    f: GetPaymentReceipt
): PaymentReceipt = exec(f) as PaymentReceipt
