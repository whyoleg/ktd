package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends phone number confirmation code
 * Should be called when user presses "https://t.me/confirmphone?phone=*******&hash=**********" or "tg://confirmphone?phone=*******&hash=**********" link
 *
 * @property hash Value of the "hash" parameter from the link
 * @property phoneNumber Value of the "phone" parameter from the link
 * @property settings Settings for the authentication of the user's phone number
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendPhoneNumberConfirmationCode(
    hash: String? = null,
    phoneNumber: String? = null,
    settings: TdPhoneNumberAuthenticationSettings? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdAuthenticationCodeInfo = exec(TdSendPhoneNumberConfirmationCode(hash, phoneNumber, settings,
        extra))
