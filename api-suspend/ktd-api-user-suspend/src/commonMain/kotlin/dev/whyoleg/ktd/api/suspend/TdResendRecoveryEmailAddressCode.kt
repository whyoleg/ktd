package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Resends the 2-step verification recovery email address verification code
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.resendRecoveryEmailAddressCode(extra: TdExtra = TdExtra.EMPTY):
        TdPasswordState = exec(TdResendRecoveryEmailAddressCode(extra))
