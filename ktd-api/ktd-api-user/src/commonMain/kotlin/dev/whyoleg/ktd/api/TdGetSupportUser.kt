package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a user that can be contacted to get support
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getSupportUser")
data class TdGetSupportUser(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdUser> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetSupportUser {
        return copy(extra = extra.copy(id = id))
    }
}
