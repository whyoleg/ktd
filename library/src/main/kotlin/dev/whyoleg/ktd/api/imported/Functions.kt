@file:Suppress("unused")

package dev.whyoleg.ktd.api.imported

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Adds new contacts or edits existing contacts; contacts' user identifiers are ignored
 */
suspend fun TelegramClient.imported(
    f: ImportContacts
): ImportedContacts = execRaw(f) as ImportedContacts

/**
 * Changes imported contacts using the list of current user contacts saved on the device. Imports newly added contacts and, if at least the file database is enabled, deletes recently deleted contacts.
 * Query result depends on the result of the previous query, so only one query is possible at the same time
 */
suspend fun TelegramClient.imported(
    f: ChangeImportedContacts
): ImportedContacts = execRaw(f) as ImportedContacts

/**
 * Clears all imported contacts, contact list remains unchanged
 */
suspend fun TelegramClient.imported(
    f: ClearImportedContacts
): Ok = execRaw(f) as Ok
