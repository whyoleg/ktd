package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the phone number of the user and sends an authentication code to the user's new phone number
 * On success, returns information about the sent code
 *
 * @property phoneNumber The new phone number of the user in international format
 * @property settings Settings for the authentication of the user's phone number
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.changePhoneNumber(
    phoneNumber: String? = null,
    settings: TdPhoneNumberAuthenticationSettings? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdAuthenticationCodeInfo = exec(TdChangePhoneNumber(phoneNumber, settings, extra))
