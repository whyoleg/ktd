package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns an HTTPS link, which can be used to add a proxy
 * Available only for SOCKS5 and MTProto proxies
 * Can be called before authorization
 *
 * @property proxyId Proxy identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getProxyLink")
data class TdGetProxyLink(
    @SerialName("proxy_id")
    val proxyId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdText> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetProxyLink {
        return copy(extra = extra.copy(id = id))
    }
}
