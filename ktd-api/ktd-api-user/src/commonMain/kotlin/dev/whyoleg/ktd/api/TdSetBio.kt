package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the bio of the current user
 *
 * @property bio The new value of the user bio
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setBio")
data class TdSetBio(
    @SerialName("bio")
    val bio: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetBio {
        return copy(extra = extra.copy(id = id))
    }
}
