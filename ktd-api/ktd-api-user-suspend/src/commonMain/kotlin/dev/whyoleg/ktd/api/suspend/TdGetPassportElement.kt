package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns one of the available Telegram Passport elements
 *
 * @property type Telegram Passport element type
 * @property password Password of the current user
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getPassportElement(
    type: TdPassportElementType? = null,
    password: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdPassportElement = exec(TdGetPassportElement(type, password, extra))
