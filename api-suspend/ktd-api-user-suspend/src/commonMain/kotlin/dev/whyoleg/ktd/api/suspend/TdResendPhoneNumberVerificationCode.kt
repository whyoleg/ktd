package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Re-sends the code to verify a phone number to be added to a user's Telegram Passport
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.resendPhoneNumberVerificationCode(extra: TdExtra = TdExtra.EMPTY):
        TdAuthenticationCodeInfo = exec(TdResendPhoneNumberVerificationCode(extra))
