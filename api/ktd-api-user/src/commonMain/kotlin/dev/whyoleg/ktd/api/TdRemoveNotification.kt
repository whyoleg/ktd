package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes an active notification from notification list
 * Needs to be called only if the notification is removed by the current user
 *
 * @property notificationGroupId Identifier of notification group to which the notification belongs
 * @property notificationId Identifier of removed notification
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeNotification")
data class TdRemoveNotification(
    @SerialName("notification_group_id")
    val notificationGroupId: Int = 0,
    @SerialName("notification_id")
    val notificationId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveNotification {
        return copy(extra = extra.copy(id = id))
    }
}
