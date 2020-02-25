@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.shipping

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.shipping(f: TdAnswerShippingQuery): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("answerShippingQuery(shippingQueryId, shippingOptions, errorMessage)",
            "dev.whyoleg.ktd.api.suspend.answerShippingQuery"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.answerShippingQuery(
    shippingQueryId: Long = 0L,
    shippingOptions: List<TdShippingOption> = emptyList(),
    errorMessage: String? = null
): TdOk = exec(TdAnswerShippingQuery(shippingQueryId, shippingOptions, errorMessage))
