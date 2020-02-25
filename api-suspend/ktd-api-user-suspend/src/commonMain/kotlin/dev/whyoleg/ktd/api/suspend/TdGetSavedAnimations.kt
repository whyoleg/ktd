package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns saved animations
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getSavedAnimations(extra: TdExtra = TdExtra.EMPTY): TdAnimations =
        exec(TdGetSavedAnimations(extra))
