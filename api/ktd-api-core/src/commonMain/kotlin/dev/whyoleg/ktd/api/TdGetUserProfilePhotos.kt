package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the profile photos of a user
 * The result of this query may be outdated: some photos might have been deleted already
 *
 * @property userId User identifier
 * @property offset The number of photos to skip
 * @property limit The maximum number of photos to be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getUserProfilePhotos")
data class TdGetUserProfilePhotos(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("offset")
    val offset: Int = 0,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdUserProfilePhotos> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetUserProfilePhotos {
        return copy(extra = extra.copy(id = id))
    }
}
