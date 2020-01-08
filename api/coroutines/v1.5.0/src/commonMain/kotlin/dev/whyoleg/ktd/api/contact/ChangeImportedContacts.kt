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
 * Changes imported contacts using the list of current user contacts saved on the device
 * Imports newly added contacts and, if at least the file database is enabled, deletes recently deleted contacts
 * Query result depends on the result of the previous query, so only one query is possible at the same time
 *
 * @contacts - The new list of contacts, contact's vCard are ignored and are not imported
 */
suspend fun TelegramClient.changeImportedContacts(
    contacts: Array<Contact> = emptyArray()
): ImportedContacts = contact(
    ChangeImportedContacts(
        contacts
    )
)

/**
 * Changes imported contacts using the list of current user contacts saved on the device
 * Imports newly added contacts and, if at least the file database is enabled, deletes recently deleted contacts
 * Query result depends on the result of the previous query, so only one query is possible at the same time
 */
suspend fun TelegramClient.contact(
    f: ChangeImportedContacts
): ImportedContacts = exec(f) as ImportedContacts
