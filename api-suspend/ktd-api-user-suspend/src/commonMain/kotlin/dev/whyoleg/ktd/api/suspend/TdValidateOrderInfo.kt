package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Validates the order information provided by a user and returns the available shipping options for a flexible invoice
 *
 * @property chatId Chat identifier of the Invoice message
 * @property messageId Message identifier
 * @property orderInfo The order information, provided by the user
 * @property allowSave True, if the order information can be saved
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.validateOrderInfo(
    chatId: Long = 0L,
    messageId: Long = 0L,
    orderInfo: TdOrderInfo? = null,
    allowSave: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdValidatedOrderInfo = exec(TdValidateOrderInfo(chatId, messageId, orderInfo, allowSave, extra))
