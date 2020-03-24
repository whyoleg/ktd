package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Checks the authentication code sent to confirm a new phone number of the user
 *
 * @property code Verification code received by SMS, phone call or flash call
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.checkChangePhoneNumberCode(code: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdCheckChangePhoneNumberCode(code, extra))
