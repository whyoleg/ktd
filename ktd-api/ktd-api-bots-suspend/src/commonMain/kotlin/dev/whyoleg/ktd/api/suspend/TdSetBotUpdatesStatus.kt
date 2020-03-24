package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Informs the server about the number of pending bot updates if they haven't been processed for a long time
 *
 * @property pendingUpdateCount The number of pending updates
 * @property errorMessage The last error message
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setBotUpdatesStatus(
    pendingUpdateCount: Int = 0,
    errorMessage: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetBotUpdatesStatus(pendingUpdateCount, errorMessage, extra))
