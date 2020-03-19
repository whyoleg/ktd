package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Clears the list of recently found chats
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.clearRecentlyFoundChats(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdClearRecentlyFoundChats(extra))
