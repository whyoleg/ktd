@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.contact

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Adds a user to the contacts list or edits an existing contact by their user_id
 *
 * @contact - The contact to add or edit
 *            Phone number can be empty and needs to be specified only if known, vCard is ignored
 * @sharePhoneNumber - True, if the new contact needs to be allowed to see current user's phone number
 *                     A corresponding rule to userPrivacySettingShowPhoneNumber will be added if needed
 *                     Use the field UserFullInfo.need_phone_number_privacy_exception to check whether the current user needs to be asked to share his phone number
 */
suspend fun TelegramClient.addContact(
    contact: Contact? = null,
    sharePhoneNumber: Boolean = false
): Ok = contact(
    AddContact(
        contact,
        sharePhoneNumber
    )
)

/**
 * Adds a user to the contacts list or edits an existing contact by their user_id
 */
suspend fun TelegramClient.contact(
    f: AddContact
): Ok = exec(f) as Ok
