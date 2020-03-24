package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a successful payment
 *
 * @property chatId Chat identifier of the PaymentSuccessful message
 * @property messageId Message identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getPaymentReceipt(
    chatId: Long = 0L,
    messageId: Long = 0L,
    extra: TdExtra = TdExtra.EMPTY
): TdPaymentReceipt = exec(TdGetPaymentReceipt(chatId, messageId, extra))
