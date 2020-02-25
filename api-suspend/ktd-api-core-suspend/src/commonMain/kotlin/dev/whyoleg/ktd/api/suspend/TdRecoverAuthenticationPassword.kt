package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Recovers the password with a password recovery code sent to an email address that was previously set up
 * Works only when the current authorization state is authorizationStateWaitPassword
 *
 * @property recoveryCode Recovery code to check
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.recoverAuthenticationPassword(recoveryCode: String? = null,
        extra: TdExtra = TdExtra.EMPTY): TdOk = exec(TdRecoverAuthenticationPassword(recoveryCode,
        extra))
