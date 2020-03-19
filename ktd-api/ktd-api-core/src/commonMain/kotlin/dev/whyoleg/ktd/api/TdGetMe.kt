package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the current user
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getMe")
data class TdGetMe(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdUser> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetMe {
        return copy(extra = extra.copy(id = id))
    }
}
