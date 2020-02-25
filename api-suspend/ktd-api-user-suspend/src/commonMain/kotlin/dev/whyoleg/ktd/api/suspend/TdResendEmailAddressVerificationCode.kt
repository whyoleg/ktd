package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Re-sends the code to verify an email address to be added to a user's Telegram Passport
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.resendEmailAddressVerificationCode(extra: TdExtra = TdExtra.EMPTY):
        TdEmailAddressAuthenticationCodeInfo = exec(TdResendEmailAddressVerificationCode(extra))
