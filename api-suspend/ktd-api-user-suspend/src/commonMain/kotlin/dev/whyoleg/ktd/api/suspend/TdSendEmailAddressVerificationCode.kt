package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends a code to verify an email address to be added to a user's Telegram Passport
 *
 * @property emailAddress Email address
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendEmailAddressVerificationCode(emailAddress: String? = null,
        extra: TdExtra = TdExtra.EMPTY): TdEmailAddressAuthenticationCodeInfo =
        exec(TdSendEmailAddressVerificationCode(emailAddress, extra))
