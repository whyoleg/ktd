package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Uses current user IP to found their country
 * Returns two-letter ISO 3166-1 alpha-2 country code
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getCountryCode(extra: TdExtra = TdExtra.EMPTY): TdText =
        exec(TdGetCountryCode(extra))
