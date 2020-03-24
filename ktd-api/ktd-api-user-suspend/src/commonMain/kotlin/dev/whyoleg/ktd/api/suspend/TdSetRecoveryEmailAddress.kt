package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the 2-step verification recovery email address of the user
 * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
 * If new_recovery_email_address is the same as the email address that is currently set up, this call succeeds immediately and aborts all other requests waiting for an email confirmation
 *
 * @property password Password of the current user
 * @property newRecoveryEmailAddress New recovery email address
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setRecoveryEmailAddress(
    password: String? = null,
    newRecoveryEmailAddress: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdPasswordState = exec(TdSetRecoveryEmailAddress(password, newRecoveryEmailAddress, extra))
