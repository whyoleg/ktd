@file:Suppress("unused")

package dev.whyoleg.ktd.api.imported

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Adds new contacts or edits existing contacts; contacts' user identifiers are ignored
 *
 * @contacts - The list of contacts to import or edit, contact's vCard are ignored and are not imported
 */
suspend fun TelegramClient.importContacts(
    contacts: Array<Contact>
): ImportedContacts = imported(
    ImportContacts(
        contacts
    )
)

/**
 * Changes imported contacts using the list of current user contacts saved on the device. Imports newly added contacts and, if at least the file database is enabled, deletes recently deleted contacts.
 * Query result depends on the result of the previous query, so only one query is possible at the same time
 *
 * @contacts - The new list of contacts, contact's vCard are ignored and are not imported
 */
suspend fun TelegramClient.changeImportedContacts(
    contacts: Array<Contact>
): ImportedContacts = imported(
    ChangeImportedContacts(
        contacts
    )
)

/**
 * Clears all imported contacts, contact list remains unchanged
 */
suspend fun TelegramClient.clearImportedContacts(): Ok = imported(
    ClearImportedContacts()
)
