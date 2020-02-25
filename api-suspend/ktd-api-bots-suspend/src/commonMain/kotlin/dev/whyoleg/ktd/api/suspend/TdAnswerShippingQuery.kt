package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sets the result of a shipping query
 *
 * @property shippingQueryId Identifier of the shipping query
 * @property shippingOptions Available shipping options
 * @property errorMessage An error message, empty on success
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.answerShippingQuery(
    shippingQueryId: Long = 0L,
    shippingOptions: List<TdShippingOption> = emptyList(),
    errorMessage: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdAnswerShippingQuery(shippingQueryId, shippingOptions, errorMessage, extra))
