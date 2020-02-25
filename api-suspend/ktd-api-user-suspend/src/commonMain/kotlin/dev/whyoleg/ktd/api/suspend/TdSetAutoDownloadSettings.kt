package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sets auto-download settings
 *
 * @property settings New user auto-download settings
 * @property type Type of the network for which the new settings are applied
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setAutoDownloadSettings(
    settings: TdAutoDownloadSettings? = null,
    type: TdNetworkType? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetAutoDownloadSettings(settings, type, extra))
