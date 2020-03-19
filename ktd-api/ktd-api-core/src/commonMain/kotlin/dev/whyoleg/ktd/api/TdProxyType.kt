package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the type of a proxy server
 */
@Serializable
sealed class TdProxyType : TdObject {
    /**
     * A SOCKS5 proxy server
     *
     * @property username Username for logging in
     * @property password Password for logging in
     */
    @Serializable
    @SerialName("proxyTypeSocks5")
    data class Socks5(
        @SerialName("username")
        val username: String?,
        @SerialName("password")
        val password: String?
    ) : TdProxyType()

    /**
     * A HTTP transparent proxy server
     *
     * @property username Username for logging in
     * @property password Password for logging in
     * @property httpOnly Pass true, if the proxy supports only HTTP requests and doesn't support transparent TCP connections via HTTP CONNECT method
     */
    @Serializable
    @SerialName("proxyTypeHttp")
    data class Http(
        @SerialName("username")
        val username: String?,
        @SerialName("password")
        val password: String?,
        @SerialName("http_only")
        val httpOnly: Boolean
    ) : TdProxyType()

    /**
     * An MTProto proxy server
     *
     * @property secret The proxy's secret in hexadecimal encoding
     */
    @Serializable
    @SerialName("proxyTypeMtproto")
    data class Mtproto(
        @SerialName("secret")
        val secret: String
    ) : TdProxyType()
}
