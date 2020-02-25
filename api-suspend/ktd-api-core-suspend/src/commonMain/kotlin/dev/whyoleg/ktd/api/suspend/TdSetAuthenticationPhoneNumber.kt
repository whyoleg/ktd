package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sets the phone number of the user and sends an authentication code to the user
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber, or if there is no pending authentication query and the current authorization state is authorizationStateWaitCode, authorizationStateWaitRegistration, or authorizationStateWaitPassword
 *
 * @property phoneNumber The phone number of the user, in international format
 * @property settings Settings for the authentication of the user's phone number
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setAuthenticationPhoneNumber(
    phoneNumber: String? = null,
    settings: TdPhoneNumberAuthenticationSettings? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetAuthenticationPhoneNumber(phoneNumber, settings, extra))
