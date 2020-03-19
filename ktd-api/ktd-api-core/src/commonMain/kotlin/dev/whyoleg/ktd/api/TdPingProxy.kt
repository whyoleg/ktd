package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Computes time needed to receive a response from a Telegram server through a proxy
 * Can be called before authorization
 *
 * @property proxyId Proxy identifier
 *                   Use 0 to ping a Telegram server without a proxy
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("pingProxy")
data class TdPingProxy(
    @SerialName("proxy_id")
    val proxyId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdSeconds> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdPingProxy {
        return copy(extra = extra.copy(id = id))
    }
}
