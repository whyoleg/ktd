package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Options to be used when a message is send
 *
 * @property disableNotification Pass true to disable notification for the message
 *                               Must be false if the message is sent to a secret chat
 * @property fromBackground Pass true if the message is sent from the background
 * @property schedulingState Message scheduling state
 *                           Messages sent to a secret chat, live location messages and self-destructing messages can't be scheduled
 */
@Serializable
@SerialName("sendMessageOptions")
data class TdSendMessageOptions(
    @SerialName("disable_notification")
    val disableNotification: Boolean,
    @SerialName("from_background")
    val fromBackground: Boolean,
    @SerialName("scheduling_state")
    val schedulingState: TdMessageSchedulingState
) : TdObject
