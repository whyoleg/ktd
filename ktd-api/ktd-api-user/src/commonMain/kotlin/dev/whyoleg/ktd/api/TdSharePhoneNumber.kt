package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Shares the phone number of the current user with a mutual contact
 * Supposed to be called when the user clicks on chatActionBarSharePhoneNumber
 *
 * @property userId Identifier of the user with whom to share the phone number
 *                  The user must be a mutual contact
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sharePhoneNumber")
data class TdSharePhoneNumber(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSharePhoneNumber {
        return copy(extra = extra.copy(id = id))
    }
}
