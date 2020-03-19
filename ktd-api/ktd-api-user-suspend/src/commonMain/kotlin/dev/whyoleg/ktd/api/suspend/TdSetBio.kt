package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the bio of the current user
 *
 * @property bio The new value of the user bio
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setBio(bio: String? = null, extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdSetBio(bio, extra))
