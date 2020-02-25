package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Information about the email address authentication code that was sent
 *
 * @property emailAddressPattern Pattern of the email address to which an authentication code was sent
 * @property length Length of the code
 *                  0 if unknown
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("emailAddressAuthenticationCodeInfo")
data class TdEmailAddressAuthenticationCodeInfo(
    @SerialName("email_address_pattern")
    val emailAddressPattern: String,
    @SerialName("length")
    val length: Int,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
