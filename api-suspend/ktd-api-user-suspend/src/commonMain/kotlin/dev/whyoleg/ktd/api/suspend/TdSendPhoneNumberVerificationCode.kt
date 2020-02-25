package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends a code to verify a phone number to be added to a user's Telegram Passport
 *
 * @property phoneNumber The phone number of the user, in international format
 * @property settings Settings for the authentication of the user's phone number
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendPhoneNumberVerificationCode(
    phoneNumber: String? = null,
    settings: TdPhoneNumberAuthenticationSettings? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdAuthenticationCodeInfo = exec(TdSendPhoneNumberVerificationCode(phoneNumber, settings, extra))
