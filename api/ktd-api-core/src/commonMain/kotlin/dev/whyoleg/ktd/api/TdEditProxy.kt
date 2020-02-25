package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Edits an existing proxy server for network requests
 * Can be called before authorization
 *
 * @property proxyId Proxy identifier
 * @property server Proxy server IP address
 * @property port Proxy server port
 * @property enable True, if the proxy should be enabled
 * @property type Proxy type
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("editProxy")
data class TdEditProxy(
    @SerialName("proxy_id")
    val proxyId: Int = 0,
    @SerialName("server")
    val server: String? = null,
    @SerialName("port")
    val port: Int = 0,
    @SerialName("enable")
    val enable: Boolean = false,
    @SerialName("type")
    val type: TdProxyType? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdProxy> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEditProxy {
        return copy(extra = extra.copy(id = id))
    }
}
