package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Information about the authentication code that was sent
 *
 * @property phoneNumber A phone number that is being authenticated
 * @property type Describes the way the code was sent to the user
 * @property nextType Describes the way the next code will be sent to the user
 * @property timeout Timeout before the code should be re-sent, in seconds
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("authenticationCodeInfo")
data class TdAuthenticationCodeInfo(
    @SerialName("phone_number")
    val phoneNumber: String,
    @SerialName("type")
    val type: TdAuthenticationCodeType,
    @SerialName("next_type")
    val nextType: TdAuthenticationCodeType?,
    @SerialName("timeout")
    val timeout: Int,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
