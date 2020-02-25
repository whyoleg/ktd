package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sets the result of a pre-checkout query
 *
 * @property preCheckoutQueryId Identifier of the pre-checkout query
 * @property errorMessage An error message, empty on success
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.answerPreCheckoutQuery(
    preCheckoutQueryId: Long = 0L,
    errorMessage: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdAnswerPreCheckoutQuery(preCheckoutQueryId, errorMessage, extra))
