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
 * Adds new contacts or edits existing contacts
 * Contacts' user identifiers are ignored
 *
 * @contacts - The list of contacts to import or edit, contact's vCard are ignored and are not imported
 */
suspend fun TelegramClient.importContacts(
    contacts: Array<Contact> = emptyArray()
): ImportedContacts = contact(
    ImportContacts(
        contacts
    )
)

/**
 * Adds new contacts or edits existing contacts
 * Contacts' user identifiers are ignored
 */
suspend fun TelegramClient.contact(
    f: ImportContacts
): ImportedContacts = exec(f) as ImportedContacts
