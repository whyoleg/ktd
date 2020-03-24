package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Deletes a profile photo
 * If something changes, updateUser will be sent
 *
 * @property profilePhotoId Identifier of the profile photo to delete
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deleteProfilePhoto")
data class TdDeleteProfilePhoto(
    @SerialName("profile_photo_id")
    val profilePhotoId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDeleteProfilePhoto {
        return copy(extra = extra.copy(id = id))
    }
}
