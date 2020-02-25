package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a user profile photo
 *
 * @property id Photo identifier
 *              0 for an empty photo
 *              Can be used to find a photo in a list of userProfilePhotos
 * @property small A small (160x160) user profile photo
 *                 The file can be downloaded only before the photo is changed
 * @property big A big (640x640) user profile photo
 *               The file can be downloaded only before the photo is changed
 */
@Serializable
@SerialName("profilePhoto")
data class TdProfilePhoto(
    @SerialName("id")
    val id: Long,
    @SerialName("small")
    val small: TdFile,
    @SerialName("big")
    val big: TdFile
) : TdObject
