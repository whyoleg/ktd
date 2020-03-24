package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes an animation from the list of saved animations
 *
 * @property animation Animation file to be removed
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeSavedAnimation(animation: TdInputFile? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdRemoveSavedAnimation(animation, extra))
