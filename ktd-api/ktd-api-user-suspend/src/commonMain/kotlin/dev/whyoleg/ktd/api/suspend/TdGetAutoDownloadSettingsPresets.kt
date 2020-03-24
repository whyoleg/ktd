package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns auto-download settings presets for the currently logged in user
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getAutoDownloadSettingsPresets(extra: TdExtra = TdExtra.EMPTY):
        TdAutoDownloadSettingsPresets = exec(TdGetAutoDownloadSettingsPresets(extra))
