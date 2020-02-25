package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for a background by its name
 *
 * @property name The name of the background
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchBackground(name: String? = null, extra: TdExtra = TdExtra.EMPTY):
        TdBackground = exec(TdSearchBackground(name, extra))
