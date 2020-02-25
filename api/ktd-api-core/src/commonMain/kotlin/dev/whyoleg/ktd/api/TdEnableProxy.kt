package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Enables a proxy
 * Only one proxy can be enabled at a time
 * Can be called before authorization
 *
 * @property proxyId Proxy identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("enableProxy")
data class TdEnableProxy(
    @SerialName("proxy_id")
    val proxyId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEnableProxy {
        return copy(extra = extra.copy(id = id))
    }
}
