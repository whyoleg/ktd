package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the period of inactivity after which the account of the current user will automatically be deleted
 *
 * @property ttl New account TTL
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setAccountTtl(ttl: TdAccountTtl? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdSetAccountTtl(ttl, extra))
