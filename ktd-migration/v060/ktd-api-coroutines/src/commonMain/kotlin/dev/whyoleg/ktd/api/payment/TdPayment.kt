@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.payment

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.payment(f: TdGetPaymentForm): TdPaymentForm = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getPaymentForm(chatId, messageId)",
            "dev.whyoleg.ktd.api.suspend.getPaymentForm"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getPaymentForm(chatId: Long = 0L, messageId: Long = 0L): TdPaymentForm =
        exec(TdGetPaymentForm(chatId, messageId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.payment(f: TdSendPaymentForm): TdPaymentResult = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("sendPaymentForm(chatId, messageId, orderInfoId, shippingOptionId, credentials)",
            "dev.whyoleg.ktd.api.suspend.sendPaymentForm"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendPaymentForm(
    chatId: Long = 0L,
    messageId: Long = 0L,
    orderInfoId: String? = null,
    shippingOptionId: String? = null,
    credentials: TdInputCredentials? = null
): TdPaymentResult = exec(TdSendPaymentForm(chatId, messageId, orderInfoId, shippingOptionId,
        credentials))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.payment(f: TdGetPaymentReceipt): TdPaymentReceipt = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getPaymentReceipt(chatId, messageId)",
            "dev.whyoleg.ktd.api.suspend.getPaymentReceipt"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getPaymentReceipt(chatId: Long = 0L, messageId: Long = 0L):
        TdPaymentReceipt = exec(TdGetPaymentReceipt(chatId, messageId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.payment(f: TdDeleteSavedCredentials): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("deleteSavedCredentials()",
            "dev.whyoleg.ktd.api.suspend.deleteSavedCredentials"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deleteSavedCredentials(): TdOk = exec(TdDeleteSavedCredentials())
