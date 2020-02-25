package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a notification
 *
 * @property id Unique persistent identifier of this notification
 * @property date Notification date
 * @property isSilent True, if the notification was initially silent
 * @property type Notification type
 */
@Serializable
@SerialName("notification")
data class TdNotification(
    @SerialName("id")
    val id: Int,
    @SerialName("date")
    val date: Int,
    @SerialName("is_silent")
    val isSilent: Boolean,
    @SerialName("type")
    val type: TdNotificationType
) : TdObject
