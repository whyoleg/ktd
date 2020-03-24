package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes a group of active notifications
 * Needs to be called only if the notification group is removed by the current user
 *
 * @property notificationGroupId Notification group identifier
 * @property maxNotificationId The maximum identifier of removed notifications
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeNotificationGroup")
data class TdRemoveNotificationGroup(
    @SerialName("notification_group_id")
    val notificationGroupId: Int = 0,
    @SerialName("max_notification_id")
    val maxNotificationId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveNotificationGroup {
        return copy(extra = extra.copy(id = id))
    }
}
