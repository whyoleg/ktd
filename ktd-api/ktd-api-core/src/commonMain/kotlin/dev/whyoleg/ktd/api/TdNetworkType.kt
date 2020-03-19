package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents the type of a network
 */
@Serializable
sealed class TdNetworkType : TdObject {
    /**
     * The network is not available
     */
    @Serializable
    @SerialName("networkTypeNone")
    object None : TdNetworkType()

    /**
     * A mobile network
     */
    @Serializable
    @SerialName("networkTypeMobile")
    object Mobile : TdNetworkType()

    /**
     * A mobile roaming network
     */
    @Serializable
    @SerialName("networkTypeMobileRoaming")
    object MobileRoaming : TdNetworkType()

    /**
     * A Wi-Fi network
     */
    @Serializable
    @SerialName("networkTypeWiFi")
    object WiFi : TdNetworkType()

    /**
     * A different network type (e.g., Ethernet network)
     */
    @Serializable
    @SerialName("networkTypeOther")
    object Other : TdNetworkType()
}
