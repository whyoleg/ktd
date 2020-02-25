package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains statistics about network usage
 */
@Serializable
sealed class TdNetworkStatisticsEntry : TdObject {
    /**
     * Contains information about the total amount of data that was used to send and receive files
     *
     * @property fileType Type of the file the data is part of
     * @property networkType Type of the network the data was sent through
     *                       Call setNetworkType to maintain the actual network type
     * @property sentBytes Total number of bytes sent
     * @property receivedBytes Total number of bytes received
     */
    @Serializable
    @SerialName("networkStatisticsEntryFile")
    data class File(
        @SerialName("file_type")
        val fileType: TdFileType,
        @SerialName("network_type")
        val networkType: TdNetworkType,
        @SerialName("sent_bytes")
        val sentBytes: Long,
        @SerialName("received_bytes")
        val receivedBytes: Long
    ) : TdNetworkStatisticsEntry()

    /**
     * Contains information about the total amount of data that was used for calls
     *
     * @property networkType Type of the network the data was sent through
     *                       Call setNetworkType to maintain the actual network type
     * @property sentBytes Total number of bytes sent
     * @property receivedBytes Total number of bytes received
     * @property duration Total call duration, in seconds
     */
    @Serializable
    @SerialName("networkStatisticsEntryCall")
    data class Call(
        @SerialName("network_type")
        val networkType: TdNetworkType,
        @SerialName("sent_bytes")
        val sentBytes: Long,
        @SerialName("received_bytes")
        val receivedBytes: Long,
        @SerialName("duration")
        val duration: Double
    ) : TdNetworkStatisticsEntry()
}
