package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Requests to send a password recovery code to an email address that was previously set up
 * Works only when the current authorization state is authorizationStateWaitPassword
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.requestAuthenticationPasswordRecovery(extra: TdExtra = TdExtra.EMPTY):
        TdOk = exec(TdRequestAuthenticationPasswordRecovery(extra))
