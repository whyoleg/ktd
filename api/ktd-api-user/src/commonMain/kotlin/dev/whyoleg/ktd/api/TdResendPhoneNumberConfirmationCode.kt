package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Resends phone number confirmation code
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("resendPhoneNumberConfirmationCode")
data class TdResendPhoneNumberConfirmationCode(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdAuthenticationCodeInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdResendPhoneNumberConfirmationCode {
        return copy(extra = extra.copy(id = id))
    }
}
