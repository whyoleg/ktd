package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains full information about a user profile photo
 *
 * @property id Unique user profile photo identifier
 * @property addedDate Point in time (Unix timestamp) when the photo has been added
 * @property sizes Available variants of the user photo, in different sizes
 */
@Serializable
@SerialName("userProfilePhoto")
data class TdUserProfilePhoto(
    @SerialName("id")
    val id: Long,
    @SerialName("added_date")
    val addedDate: Int,
    @SerialName("sizes")
    val sizes: List<TdPhotoSize>
) : TdObject
