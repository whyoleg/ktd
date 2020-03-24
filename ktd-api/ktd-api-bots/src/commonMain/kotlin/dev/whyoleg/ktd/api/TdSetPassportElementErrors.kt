package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Informs the user that some of the elements in their Telegram Passport contain errors
 * The user will not be able to resend the elements, until the errors are fixed
 *
 * @property userId User identifier
 * @property errors The errors
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setPassportElementErrors")
data class TdSetPassportElementErrors(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("errors")
    val errors: List<TdInputPassportElementError> = emptyList(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetPassportElementErrors {
        return copy(extra = extra.copy(id = id))
    }
}
