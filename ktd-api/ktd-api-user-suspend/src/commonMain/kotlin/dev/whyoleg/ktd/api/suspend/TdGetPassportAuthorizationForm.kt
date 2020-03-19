package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a Telegram Passport authorization form for sharing data with a service
 *
 * @property botUserId User identifier of the service's bot
 * @property scope Telegram Passport element types requested by the service
 * @property publicKey Service's public_key
 * @property nonce Authorization form nonce provided by the service
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getPassportAuthorizationForm(
    botUserId: Int = 0,
    scope: String? = null,
    publicKey: String? = null,
    nonce: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdPassportAuthorizationForm = exec(TdGetPassportAuthorizationForm(botUserId, scope, publicKey,
        nonce, extra))
