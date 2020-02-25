package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the period of inactivity after which the account of the current user will automatically be deleted
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getAccountTtl(extra: TdExtra = TdExtra.EMPTY): TdAccountTtl =
        exec(TdGetAccountTtl(extra))
