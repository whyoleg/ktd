package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Manually adds a new animation to the list of saved animations
 * The new animation is added to the beginning of the list
 * If the animation was already in the list, it is removed first
 * Only non-secret video animations with MIME type "video/mp4" can be added to the list
 *
 * @property animation The animation file to be added
 *                     Only animations known to the server (i.e
 *                     Successfully sent via a message) can be added to the list
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.addSavedAnimation(animation: TdInputFile? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdAddSavedAnimation(animation, extra))
