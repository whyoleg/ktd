package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Re-sends the authentication code sent to confirm a new phone number for the user
 * Works only if the previously received authenticationCodeInfo next_code_type was not null
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.resendChangePhoneNumberCode(extra: TdExtra = TdExtra.EMPTY):
        TdAuthenticationCodeInfo = exec(TdResendChangePhoneNumberCode(extra))
