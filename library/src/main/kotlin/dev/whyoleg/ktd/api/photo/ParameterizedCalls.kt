@file:Suppress("unused")

package dev.whyoleg.ktd.api.photo

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Uploads a new profile photo for the current user. If something changes, updateUser will be sent
 *
 * @photo - Profile photo to set. inputFileId and inputFileRemote may still be unsupported
 */
suspend fun TelegramClient.setProfilePhoto(
    photo: InputFile
): Ok = photo(
    SetProfilePhoto(
        photo
    )
)

/**
 * Deletes a profile photo. If something changes, updateUser will be sent
 *
 * @profilePhotoId - Identifier of the profile photo to delete
 */
suspend fun TelegramClient.deleteProfilePhoto(
    profilePhotoId: Long
): Ok = photo(
    DeleteProfilePhoto(
        profilePhotoId
    )
)
