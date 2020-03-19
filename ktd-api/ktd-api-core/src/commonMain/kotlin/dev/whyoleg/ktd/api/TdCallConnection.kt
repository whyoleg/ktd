package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the address of UDP reflectors
 *
 * @property id Reflector identifier
 * @property ip IPv4 reflector address
 * @property ipv6 IPv6 reflector address
 * @property port Reflector port number
 * @property peerTag Connection peer tag
 */
@Serializable
@SerialName("callConnection")
data class TdCallConnection(
    @SerialName("id")
    val id: Long,
    @SerialName("ip")
    val ip: String,
    @SerialName("ipv6")
    val ipv6: String,
    @SerialName("port")
    val port: Int,
    @SerialName("peer_tag")
    val peerTag: ByteArray
) : TdObject
