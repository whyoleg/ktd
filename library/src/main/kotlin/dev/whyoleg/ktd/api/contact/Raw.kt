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
 */
suspend fun TelegramClient.contact(
    f: ImportContacts
): ImportedContacts = execRaw(f) as ImportedContacts

/**
 * Removes users from the contact list
 */
suspend fun TelegramClient.contact(
    f: RemoveContacts
): Ok = execRaw(f) as Ok

/**
 * Returns the total number of imported contacts
 */
suspend fun TelegramClient.contact(
    f: GetImportedContactCount
): Count = execRaw(f) as Count

/**
 * Changes imported contacts using the list of current user contacts saved on the device
 * Imports newly added contacts and, if at least the file database is enabled, deletes recently deleted contacts
 * Query result depends on the result of the previous query, so only one query is possible at the same time
 */
suspend fun TelegramClient.contact(
    f: ChangeImportedContacts
): ImportedContacts = execRaw(f) as ImportedContacts

/**
 * Clears all imported contacts, contact list remains unchanged
 */
suspend fun TelegramClient.contact(
    f: ClearImportedContacts
): Ok = execRaw(f) as Ok
