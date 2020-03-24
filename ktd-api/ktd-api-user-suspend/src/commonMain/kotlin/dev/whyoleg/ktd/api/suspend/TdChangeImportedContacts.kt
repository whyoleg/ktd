package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes imported contacts using the list of current user contacts saved on the device
 * Imports newly added contacts and, if at least the file database is enabled, deletes recently deleted contacts
 * Query result depends on the result of the previous query, so only one query is possible at the same time
 *
 * @property contacts The new list of contacts, contact's vCard are ignored and are not imported
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.changeImportedContacts(contacts: List<TdContact> = emptyList(),
        extra: TdExtra = TdExtra.EMPTY): TdImportedContacts =
        exec(TdChangeImportedContacts(contacts, extra))
