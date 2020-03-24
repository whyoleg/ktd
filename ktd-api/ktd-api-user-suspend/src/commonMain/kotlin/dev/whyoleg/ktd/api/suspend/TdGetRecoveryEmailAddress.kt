package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a 2-step verification recovery email address that was previously set up
 * This method can be used to verify a password provided by the user
 *
 * @property password The password for the current user
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getRecoveryEmailAddress(password: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdRecoveryEmailAddress = exec(TdGetRecoveryEmailAddress(password, extra))
