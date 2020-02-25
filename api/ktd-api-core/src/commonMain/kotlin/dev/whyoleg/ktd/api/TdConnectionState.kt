package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the current state of the connection to Telegram servers
 */
@Serializable
sealed class TdConnectionState : TdObject {
    /**
     * Currently waiting for the network to become available
     * Use setNetworkType to change the available network type
     */
    @Serializable
    @SerialName("connectionStateWaitingForNetwork")
    object WaitingForNetwork : TdConnectionState()

    /**
     * Currently establishing a connection with a proxy server
     */
    @Serializable
    @SerialName("connectionStateConnectingToProxy")
    object ConnectingToProxy : TdConnectionState()

    /**
     * Currently establishing a connection to the Telegram servers
     */
    @Serializable
    @SerialName("connectionStateConnecting")
    object Connecting : TdConnectionState()

    /**
     * Downloading data received while the client was offline
     */
    @Serializable
    @SerialName("connectionStateUpdating")
    object Updating : TdConnectionState()

    /**
     * There is a working connection to the Telegram servers
     */
    @Serializable
    @SerialName("connectionStateReady")
    object Ready : TdConnectionState()
}
