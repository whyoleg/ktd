package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about the sending state of the message
 */
@Serializable
sealed class TdMessageSendingState : TdObject {
    /**
     * The message is being sent now, but has not yet been delivered to the server
     */
    @Serializable
    @SerialName("messageSendingStatePending")
    object Pending : TdMessageSendingState()

    /**
     * The message failed to be sent
     *
     * @property errorCode An error code
     *                     0 if unknown
     * @property errorMessage Error message
     * @property canRetry True, if the message can be re-sent
     * @property retryAfter Time left before the message can be re-sent, in seconds
     *                      No update is sent when this field changes
     */
    @Serializable
    @SerialName("messageSendingStateFailed")
    data class Failed(
        @SerialName("error_code")
        val errorCode: Int,
        @SerialName("error_message")
        val errorMessage: String,
        @SerialName("can_retry")
        val canRetry: Boolean,
        @SerialName("retry_after")
        val retryAfter: Double
    ) : TdMessageSendingState()
}
