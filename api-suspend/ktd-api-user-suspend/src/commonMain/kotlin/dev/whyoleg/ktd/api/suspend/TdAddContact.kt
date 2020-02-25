package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

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
suspend fun SuspendTdClient.addContact(
    contact: TdContact? = null,
    sharePhoneNumber: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdAddContact(contact, sharePhoneNumber, extra))
