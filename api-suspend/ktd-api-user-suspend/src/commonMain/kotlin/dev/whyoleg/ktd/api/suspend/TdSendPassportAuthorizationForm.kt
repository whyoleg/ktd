package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends a Telegram Passport authorization form, effectively sharing data with the service
 * This method must be called after getPassportAuthorizationFormAvailableElements if some previously available elements need to be used
 *
 * @property autorizationFormId Authorization form identifier
 * @property types Types of Telegram Passport elements chosen by user to complete the authorization form
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendPassportAuthorizationForm(
    autorizationFormId: Int = 0,
    types: List<TdPassportElementType> = emptyList(),
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSendPassportAuthorizationForm(autorizationFormId, types, extra))
