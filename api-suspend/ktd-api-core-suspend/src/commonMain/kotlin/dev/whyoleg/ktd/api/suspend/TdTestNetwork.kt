package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends a simple network request to the Telegram servers
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.testNetwork(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdTestNetwork(extra))
