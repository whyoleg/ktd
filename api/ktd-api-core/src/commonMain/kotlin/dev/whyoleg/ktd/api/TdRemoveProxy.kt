package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes a proxy server
 * Can be called before authorization
 *
 * @property proxyId Proxy identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeProxy")
data class TdRemoveProxy(
    @SerialName("proxy_id")
    val proxyId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveProxy {
        return copy(extra = extra.copy(id = id))
    }
}
