package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Checks the authentication password for correctness
 * Works only when the current authorization state is authorizationStateWaitPassword
 *
 * @property password The password to check
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.checkAuthenticationPassword(password: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdCheckAuthenticationPassword(password, extra))
