package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the profile photos of a user
 * The result of this query may be outdated: some photos might have been deleted already
 *
 * @property userId User identifier
 * @property offset The number of photos to skip
 * @property limit The maximum number of photos to be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getUserProfilePhotos(
    userId: Int = 0,
    offset: Int = 0,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdUserProfilePhotos = exec(TdGetUserProfilePhotos(userId, offset, limit, extra))
