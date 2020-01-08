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
    photo: InputFile? = null
): Ok = profile(
    SetProfilePhoto(
        photo
    )
)

/**
 * Uploads a new profile photo for the current user
 * If something changes, updateUser will be sent
 */
suspend fun TelegramClient.profile(
    f: SetProfilePhoto
): Ok = exec(f) as Ok
