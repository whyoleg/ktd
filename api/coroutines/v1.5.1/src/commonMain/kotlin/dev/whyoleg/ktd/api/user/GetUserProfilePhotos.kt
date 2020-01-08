@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.user

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the profile photos of a user
 * The result of this query may be outdated: some photos might have been deleted already
 *
 * @userId - User identifier
 * @offset - The number of photos to skip
 * @limit - Maximum number of photos to be returned
 */
suspend fun TelegramClient.getUserProfilePhotos(
    userId: Int = 0,
    offset: Int = 0,
    limit: Int = 0
): UserProfilePhotos = user(
    GetUserProfilePhotos(
        userId,
        offset,
        limit
    )
)

/**
 * Returns the profile photos of a user
 * The result of this query may be outdated: some photos might have been deleted already
 */
suspend fun TelegramClient.user(
    f: GetUserProfilePhotos
): UserProfilePhotos = exec(f) as UserProfilePhotos
