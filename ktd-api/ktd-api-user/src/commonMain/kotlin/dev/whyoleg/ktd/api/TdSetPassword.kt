package dev.whyoleg.ktd.api

import kotlinx.serialization.*

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
@Serializable
@SerialName("setPassword")
data class TdSetPassword(
    @SerialName("old_password")
    val oldPassword: String? = null,
    @SerialName("new_password")
    val newPassword: String? = null,
    @SerialName("new_hint")
    val newHint: String? = null,
    @SerialName("set_recovery_email_address")
    val setRecoveryEmailAddress: Boolean = false,
    @SerialName("new_recovery_email_address")
    val newRecoveryEmailAddress: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPasswordState> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetPassword {
        return copy(extra = extra.copy(id = id))
    }
}
