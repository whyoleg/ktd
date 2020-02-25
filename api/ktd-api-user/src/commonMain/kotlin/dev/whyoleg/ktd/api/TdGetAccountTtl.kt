package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the period of inactivity after which the account of the current user will automatically be deleted
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getAccountTtl")
data class TdGetAccountTtl(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdAccountTtl> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetAccountTtl {
        return copy(extra = extra.copy(id = id))
    }
}
