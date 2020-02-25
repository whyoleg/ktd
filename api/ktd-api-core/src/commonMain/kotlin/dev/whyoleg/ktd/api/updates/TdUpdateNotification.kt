package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * A notification was changed
 *
 * @property notificationGroupId Unique notification group identifier
 * @property notification Changed notification
 */
@Serializable
@SerialName("updateNotification")
data class TdUpdateNotification(
    @SerialName("notification_group_id")
    val notificationGroupId: Int,
    @SerialName("notification")
    val notification: TdNotification
) : TdUpdate
