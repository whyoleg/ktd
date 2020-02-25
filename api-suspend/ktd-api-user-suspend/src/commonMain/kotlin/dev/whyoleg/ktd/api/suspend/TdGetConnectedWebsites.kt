package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns all website where the current user used Telegram to log in
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getConnectedWebsites(extra: TdExtra = TdExtra.EMPTY):
        TdConnectedWebsites = exec(TdGetConnectedWebsites(extra))
