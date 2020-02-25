package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Clears all imported contacts, contact list remains unchanged
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.clearImportedContacts(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdClearImportedContacts(extra))
