package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends a filled-out payment form to the bot for final verification
 *
 * @property chatId Chat identifier of the Invoice message
 * @property messageId Message identifier
 * @property orderInfoId Identifier returned by ValidateOrderInfo, or an empty string
 * @property shippingOptionId Identifier of a chosen shipping option, if applicable
 * @property credentials The credentials chosen by user for payment
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendPaymentForm(
    chatId: Long = 0L,
    messageId: Long = 0L,
    orderInfoId: String? = null,
    shippingOptionId: String? = null,
    credentials: TdInputCredentials? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdPaymentResult = exec(TdSendPaymentForm(chatId, messageId, orderInfoId, shippingOptionId,
        credentials, extra))
