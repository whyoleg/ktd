package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds a user to the contact list or edits an existing contact by their user identifier
 *
 * @property contact The contact to add or edit
 *                   Phone number can be empty and needs to be specified only if known, vCard is ignored
 * @property sharePhoneNumber True, if the new contact needs to be allowed to see current user's phone number
 *                            A corresponding rule to userPrivacySettingShowPhoneNumber will be added if needed
 *                            Use the field UserFullInfo.need_phone_number_privacy_exception to check whether the current user needs to be asked to share their phone number
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("addContact")
data class TdAddContact(
    @SerialName("contact")
    val contact: TdContact? = null,
    @SerialName("share_phone_number")
    val sharePhoneNumber: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAddContact {
        return copy(extra = extra.copy(id = id))
    }
}
