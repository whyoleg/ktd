package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Re-sends an authentication code to the user
 * Works only when the current authorization state is authorizationStateWaitCode and the next_code_type of the result is not null
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.resendAuthenticationCode(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdResendAuthenticationCode(extra))
