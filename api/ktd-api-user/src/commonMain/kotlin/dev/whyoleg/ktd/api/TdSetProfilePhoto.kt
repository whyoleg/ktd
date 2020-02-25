package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Uploads a new profile photo for the current user
 * If something changes, updateUser will be sent
 *
 * @property photo Profile photo to set
 *                 InputFileId and inputFileRemote may still be unsupported
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setProfilePhoto")
data class TdSetProfilePhoto(
    @SerialName("photo")
    val photo: TdInputFile? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetProfilePhoto {
        return copy(extra = extra.copy(id = id))
    }
}
