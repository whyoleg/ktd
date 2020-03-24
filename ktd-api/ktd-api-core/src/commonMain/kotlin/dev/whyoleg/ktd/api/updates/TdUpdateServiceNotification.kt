package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * Service notification from the server
 * Upon receiving this the client must show a popup with the content of the notification
 *
 * @property type Notification type
 *                If type begins with "AUTH_KEY_DROP_", then two buttons "Cancel" and "Log out" should be shown under notification
 *                If user presses the second, all local data should be destroyed using Destroy method
 * @property content Notification content
 */
@Serializable
@SerialName("updateServiceNotification")
data class TdUpdateServiceNotification(
    @SerialName("type")
    val type: String,
    @SerialName("content")
    val content: TdMessageContent
) : TdUpdate
