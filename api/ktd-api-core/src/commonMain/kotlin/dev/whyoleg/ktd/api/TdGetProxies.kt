package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns list of proxies that are currently set up
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getProxies")
data class TdGetProxies(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdProxies> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetProxies {
        return copy(extra = extra.copy(id = id))
    }
}
