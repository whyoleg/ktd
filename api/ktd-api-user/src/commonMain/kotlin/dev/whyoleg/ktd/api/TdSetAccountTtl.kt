package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the period of inactivity after which the account of the current user will automatically be deleted
 *
 * @property ttl New account TTL
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setAccountTtl")
data class TdSetAccountTtl(
    @SerialName("ttl")
    val ttl: TdAccountTtl? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetAccountTtl {
        return copy(extra = extra.copy(id = id))
    }
}
