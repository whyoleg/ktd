package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends a simple network request to the Telegram servers via proxy
 * Can be called before authorization
 *
 * @property server Proxy server IP address
 * @property port Proxy server port
 * @property type Proxy type
 * @property dcId Identifier of a datacenter, with which to test connection
 * @property timeout The maximum overall timeout for the request
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testProxy")
data class TdTestProxy(
    @SerialName("server")
    val server: String? = null,
    @SerialName("port")
    val port: Int = 0,
    @SerialName("type")
    val type: TdProxyType? = null,
    @SerialName("dc_id")
    val dcId: Int = 0,
    @SerialName("timeout")
    val timeout: Double = 0.0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTestProxy {
        return copy(extra = extra.copy(id = id))
    }
}
