@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.profile

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Deletes a profile photo
 * If something changes, updateUser will be sent
 *
 * @profilePhotoId - Identifier of the profile photo to delete
 */
suspend fun TelegramClient.deleteProfilePhoto(
    profilePhotoId: Long = 0L
): Ok = profile(
    DeleteProfilePhoto(
        profilePhotoId
    )
)

/**
 * Deletes a profile photo
 * If something changes, updateUser will be sent
 */
suspend fun TelegramClient.profile(
    f: DeleteProfilePhoto
): Ok = exec(f) as Ok
