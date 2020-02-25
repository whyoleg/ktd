package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Specifies the supported call protocols
 *
 * @property udpP2p True, if UDP peer-to-peer connections are supported
 * @property udpReflector True, if connection through UDP reflectors is supported
 * @property minLayer The minimum supported API layer
 * @property maxLayer The maximum supported API layer
 */
@Serializable
@SerialName("callProtocol")
data class TdCallProtocol(
    @SerialName("udp_p2p")
    val udpP2p: Boolean,
    @SerialName("udp_reflector")
    val udpReflector: Boolean,
    @SerialName("min_layer")
    val minLayer: Int,
    @SerialName("max_layer")
    val maxLayer: Int
) : TdObject
