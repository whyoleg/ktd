package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains part of the list of user photos
 *
 * @property totalCount Total number of user profile photos
 * @property photos A list of photos
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("userProfilePhotos")
data class TdUserProfilePhotos(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("photos")
    val photos: List<TdUserProfilePhoto>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
