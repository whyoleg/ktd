package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Recovers the password using a recovery code sent to an email address that was previously set up
 *
 * @property recoveryCode Recovery code to check
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.recoverPassword(recoveryCode: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdPasswordState = exec(TdRecoverPassword(recoveryCode, extra))
