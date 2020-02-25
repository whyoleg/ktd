package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns already available Telegram Passport elements suitable for completing a Telegram Passport authorization form
 * Result can be received only once for each authorization form
 *
 * @property autorizationFormId Authorization form identifier
 * @property password Password of the current user
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getPassportAuthorizationFormAvailableElements")
data class TdGetPassportAuthorizationFormAvailableElements(
    @SerialName("autorization_form_id")
    val autorizationFormId: Int = 0,
    @SerialName("password")
    val password: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPassportElementsWithErrors> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetPassportAuthorizationFormAvailableElements {
        return copy(extra = extra.copy(id = id))
    }
}
