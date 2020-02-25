package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of recently inactive supergroups and channels
 * Can be used when user reaches limit on the number of joined supergroups and channels and receives CHANNELS_TOO_MUCH error
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getInactiveSupergroupChats(extra: TdExtra = TdExtra.EMPTY): TdChats =
        exec(TdGetInactiveSupergroupChats(extra))
