package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds new contacts or edits existing contacts by their phone numbers
 * Contacts' user identifiers are ignored
 *
 * @property contacts The list of contacts to import or edit
 *                    Contacts' vCard are ignored and are not imported
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.importContacts(contacts: List<TdContact> = emptyList(), extra: TdExtra =
        TdExtra.EMPTY): TdImportedContacts = exec(TdImportContacts(contacts, extra))
