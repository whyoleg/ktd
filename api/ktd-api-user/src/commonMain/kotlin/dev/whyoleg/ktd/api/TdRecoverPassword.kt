package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Recovers the password using a recovery code sent to an email address that was previously set up
 *
 * @property recoveryCode Recovery code to check
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("recoverPassword")
data class TdRecoverPassword(
    @SerialName("recovery_code")
    val recoveryCode: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPasswordState> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRecoverPassword {
        return copy(extra = extra.copy(id = id))
    }
}
