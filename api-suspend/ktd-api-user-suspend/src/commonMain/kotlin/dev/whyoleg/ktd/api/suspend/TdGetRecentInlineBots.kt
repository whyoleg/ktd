package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns up to 20 recently used inline bots in the order of their last usage
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getRecentInlineBots(extra: TdExtra = TdExtra.EMPTY): TdUsers =
        exec(TdGetRecentInlineBots(extra))
