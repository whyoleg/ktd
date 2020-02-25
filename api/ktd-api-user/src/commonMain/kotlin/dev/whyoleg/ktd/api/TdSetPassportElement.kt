package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds an element to the user's Telegram Passport
 * May return an error with a message "PHONE_VERIFICATION_NEEDED" or "EMAIL_VERIFICATION_NEEDED" if the chosen phone number or the chosen email address must be verified first
 *
 * @property element Input Telegram Passport element
 * @property password Password of the current user
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setPassportElement")
data class TdSetPassportElement(
    @SerialName("element")
    val element: TdInputPassportElement? = null,
    @SerialName("password")
    val password: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPassportElement> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetPassportElement {
        return copy(extra = extra.copy(id = id))
    }
}
