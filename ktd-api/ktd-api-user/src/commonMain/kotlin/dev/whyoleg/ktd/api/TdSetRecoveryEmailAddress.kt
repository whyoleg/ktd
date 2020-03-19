package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the 2-step verification recovery email address of the user
 * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
 * If new_recovery_email_address is the same as the email address that is currently set up, this call succeeds immediately and aborts all other requests waiting for an email confirmation
 *
 * @property password Password of the current user
 * @property newRecoveryEmailAddress New recovery email address
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setRecoveryEmailAddress")
data class TdSetRecoveryEmailAddress(
    @SerialName("password")
    val password: String? = null,
    @SerialName("new_recovery_email_address")
    val newRecoveryEmailAddress: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPasswordState> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetRecoveryEmailAddress {
        return copy(extra = extra.copy(id = id))
    }
}
