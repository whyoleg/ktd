package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Checks the email address verification code for Telegram Passport
 *
 * @property code Verification code
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.checkEmailAddressVerificationCode(code: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdCheckEmailAddressVerificationCode(code, extra))
