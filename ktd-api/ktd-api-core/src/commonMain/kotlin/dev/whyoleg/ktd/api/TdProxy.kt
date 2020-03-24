package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a proxy server
 *
 * @property id Unique identifier of the proxy
 * @property server Proxy server IP address
 * @property port Proxy server port
 * @property lastUsedDate Point in time (Unix timestamp) when the proxy was last used
 *                        0 if never
 * @property isEnabled True, if the proxy is enabled now
 * @property type Type of the proxy
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("proxy")
data class TdProxy(
    @SerialName("id")
    val id: Int,
    @SerialName("server")
    val server: String,
    @SerialName("port")
    val port: Int,
    @SerialName("last_used_date")
    val lastUsedDate: Int,
    @SerialName("is_enabled")
    val isEnabled: Boolean,
    @SerialName("type")
    val type: TdProxyType,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
