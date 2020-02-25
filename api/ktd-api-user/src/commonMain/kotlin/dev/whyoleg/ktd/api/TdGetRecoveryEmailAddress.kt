package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a 2-step verification recovery email address that was previously set up
 * This method can be used to verify a password provided by the user
 *
 * @property password The password for the current user
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getRecoveryEmailAddress")
data class TdGetRecoveryEmailAddress(
    @SerialName("password")
    val password: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdRecoveryEmailAddress> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetRecoveryEmailAddress {
        return copy(extra = extra.copy(id = id))
    }
}
