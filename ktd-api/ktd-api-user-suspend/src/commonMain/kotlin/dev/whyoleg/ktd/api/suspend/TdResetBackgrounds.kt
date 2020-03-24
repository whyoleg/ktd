package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Resets list of installed backgrounds to its default value
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.resetBackgrounds(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdResetBackgrounds(extra))
