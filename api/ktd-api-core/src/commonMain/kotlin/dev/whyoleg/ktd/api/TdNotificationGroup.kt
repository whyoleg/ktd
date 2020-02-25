package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a group of notifications
 *
 * @property id Unique persistent auto-incremented from 1 identifier of the notification group
 * @property type Type of the group
 * @property chatId Identifier of a chat to which all notifications in the group belong
 * @property totalCount Total number of active notifications in the group
 * @property notifications The list of active notifications
 */
@Serializable
@SerialName("notificationGroup")
data class TdNotificationGroup(
    @SerialName("id")
    val id: Int,
    @SerialName("type")
    val type: TdNotificationGroupType,
    @SerialName("chat_id")
    val chatId: Long,
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("notifications")
    val notifications: List<TdNotification>
) : TdObject
