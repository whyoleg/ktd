package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the total number of imported contacts
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getImportedContactCount(extra: TdExtra = TdExtra.EMPTY): TdCount =
        exec(TdGetImportedContactCount(extra))
