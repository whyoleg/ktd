@file:Suppress("unused")

package dev.whyoleg.ktd.api.validated

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Validates the order information provided by a user and returns the available shipping options for a flexible invoice
 *
 * @chatId - Chat identifier of the Invoice message
 * @messageId - Message identifier
 * @orderInfo - The order information, provided by the user
 * @allowSave - True, if the order information can be saved
 */
suspend fun TelegramClient.validateOrderInfo(
    chatId: Long,
    messageId: Long,
    orderInfo: OrderInfo,
    allowSave: Boolean
): ValidatedOrderInfo = validated(
    ValidateOrderInfo(
        chatId,
        messageId,
        orderInfo,
        allowSave
    )
)
