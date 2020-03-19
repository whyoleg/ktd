package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a user that can be contacted to get support
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getSupportUser(extra: TdExtra = TdExtra.EMPTY): TdUser =
        exec(TdGetSupportUser(extra))
