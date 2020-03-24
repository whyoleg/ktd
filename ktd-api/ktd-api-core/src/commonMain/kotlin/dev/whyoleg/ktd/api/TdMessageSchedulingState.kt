package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about the time when a scheduled message will be sent
 */
@Serializable
sealed class TdMessageSchedulingState : TdObject {
    /**
     * The message will be sent at the specified date
     *
     * @property sendDate Date the message will be sent
     *                    The date must be within 367 days in the future
     */
    @Serializable
    @SerialName("messageSchedulingStateSendAtDate")
    data class SendAtDate(
        @SerialName("send_date")
        val sendDate: Int
    ) : TdMessageSchedulingState()

    /**
     * The message will be sent when the peer will be online
     * Applicable to private chats only and when the exact online status of the peer is known
     */
    @Serializable
    @SerialName("messageSchedulingStateSendWhenOnline")
    object SendWhenOnline : TdMessageSchedulingState()
}
