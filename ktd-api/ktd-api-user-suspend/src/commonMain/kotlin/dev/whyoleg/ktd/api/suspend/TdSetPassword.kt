package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the password for the user
 * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
 *
 * @property oldPassword Previous password of the user
 * @property newPassword New password of the user
 *                       May be empty to remove the password
 * @property newHint New password hint
 * @property setRecoveryEmailAddress Pass true if the recovery email address should be changed
 * @property newRecoveryEmailAddress New recovery email address
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setPassword(
    oldPassword: String? = null,
    newPassword: String? = null,
    newHint: String? = null,
    setRecoveryEmailAddress: Boolean = false,
    newRecoveryEmailAddress: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdPasswordState = exec(TdSetPassword(oldPassword, newPassword, newHint, setRecoveryEmailAddress,
        newRecoveryEmailAddress, extra))
