package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Resends phone number confirmation code
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.resendPhoneNumberConfirmationCode(extra: TdExtra = TdExtra.EMPTY):
        TdAuthenticationCodeInfo = exec(TdResendPhoneNumberConfirmationCode(extra))
