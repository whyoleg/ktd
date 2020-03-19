package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Checks the 2-step verification recovery email address verification code
 *
 * @property code Verification code
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.checkRecoveryEmailAddressCode(code: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdPasswordState = exec(TdCheckRecoveryEmailAddressCode(code, extra))
