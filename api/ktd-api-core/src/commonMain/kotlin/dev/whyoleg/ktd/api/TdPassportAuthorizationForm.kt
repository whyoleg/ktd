package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a Telegram Passport authorization form that was requested
 *
 * @property id Unique identifier of the authorization form
 * @property requiredElements Information about the Telegram Passport elements that need to be provided to complete the form
 * @property privacyPolicyUrl URL for the privacy policy of the service
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("passportAuthorizationForm")
data class TdPassportAuthorizationForm(
    @SerialName("id")
    val id: Int,
    @SerialName("required_elements")
    val requiredElements: List<TdPassportRequiredElement>,
    @SerialName("privacy_policy_url")
    val privacyPolicyUrl: String?,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
