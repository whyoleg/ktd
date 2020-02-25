package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends a Telegram Passport authorization form, effectively sharing data with the service
 * This method must be called after getPassportAuthorizationFormAvailableElements if some previously available elements need to be used
 *
 * @property autorizationFormId Authorization form identifier
 * @property types Types of Telegram Passport elements chosen by user to complete the authorization form
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendPassportAuthorizationForm")
data class TdSendPassportAuthorizationForm(
    @SerialName("autorization_form_id")
    val autorizationFormId: Int = 0,
    @SerialName("types")
    val types: List<TdPassportElementType> = emptyList(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendPassportAuthorizationForm {
        return copy(extra = extra.copy(id = id))
    }
}
