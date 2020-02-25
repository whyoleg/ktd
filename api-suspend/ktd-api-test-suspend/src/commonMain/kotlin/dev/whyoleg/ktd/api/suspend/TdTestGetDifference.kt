package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Forces an updates.getDifference call to the Telegram servers
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.testGetDifference(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdTestGetDifference(extra))
