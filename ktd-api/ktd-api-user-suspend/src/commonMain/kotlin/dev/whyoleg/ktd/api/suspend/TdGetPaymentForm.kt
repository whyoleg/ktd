package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns an invoice payment form
 * This method should be called when the user presses inlineKeyboardButtonBuy
 *
 * @property chatId Chat identifier of the Invoice message
 * @property messageId Message identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getPaymentForm(
    chatId: Long = 0L,
    messageId: Long = 0L,
    extra: TdExtra = TdExtra.EMPTY
): TdPaymentForm = exec(TdGetPaymentForm(chatId, messageId, extra))
