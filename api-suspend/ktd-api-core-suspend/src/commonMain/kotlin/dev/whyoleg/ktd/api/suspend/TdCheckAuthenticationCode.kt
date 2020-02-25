package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Checks the authentication code
 * Works only when the current authorization state is authorizationStateWaitCode
 *
 * @property code The verification code received via SMS, Telegram message, phone call, or flash call
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.checkAuthenticationCode(code: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdCheckAuthenticationCode(code, extra))
