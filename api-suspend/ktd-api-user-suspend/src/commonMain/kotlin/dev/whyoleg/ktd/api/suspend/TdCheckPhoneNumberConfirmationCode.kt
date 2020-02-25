package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Checks phone number confirmation code
 *
 * @property code The phone number confirmation code
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.checkPhoneNumberConfirmationCode(code: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdCheckPhoneNumberConfirmationCode(code, extra))
