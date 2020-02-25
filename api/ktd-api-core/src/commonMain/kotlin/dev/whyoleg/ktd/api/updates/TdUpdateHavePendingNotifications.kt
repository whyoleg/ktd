package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * Describes whether there are some pending notification updates
 * Can be used to prevent application from killing, while there are some pending notifications
 *
 * @property haveDelayedNotifications True, if there are some delayed notification updates, which will be sent soon
 * @property haveUnreceivedNotifications True, if there can be some yet unreceived notifications, which are being fetched from the server
 */
@Serializable
@SerialName("updateHavePendingNotifications")
data class TdUpdateHavePendingNotifications(
    @SerialName("have_delayed_notifications")
    val haveDelayedNotifications: Boolean,
    @SerialName("have_unreceived_notifications")
    val haveUnreceivedNotifications: Boolean
) : TdUpdate
