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
 * Uploads a new profile photo for the current user
 * If something changes, updateUser will be sent
 *
 * @photo - Profile photo to set
 *          InputFileId and inputFileRemote may still be unsupported
 */
suspend fun TelegramClient.setProfilePhoto(
    photo: InputFile
): Ok = profile(
    SetProfilePhoto(
        photo
    )
)

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
