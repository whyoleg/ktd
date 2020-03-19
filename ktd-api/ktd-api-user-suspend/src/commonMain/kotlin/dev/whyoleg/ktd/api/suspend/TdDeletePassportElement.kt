package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Deletes a Telegram Passport element
 *
 * @property type Element type
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.deletePassportElement(type: TdPassportElementType? = null,
        extra: TdExtra = TdExtra.EMPTY): TdOk = exec(TdDeletePassportElement(type, extra))
