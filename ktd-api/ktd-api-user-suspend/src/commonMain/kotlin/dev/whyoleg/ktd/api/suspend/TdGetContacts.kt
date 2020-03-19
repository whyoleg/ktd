package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns all user contacts
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getContacts(extra: TdExtra = TdExtra.EMPTY): TdUsers =
        exec(TdGetContacts(extra))
