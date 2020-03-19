package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * Contains active notifications that was shown on previous application launches
 * This update is sent only if the message database is used
 * In that case it comes once before any updateNotification and updateNotificationGroup update
 *
 * @property groups Lists of active notification groups
 */
@Serializable
@SerialName("updateActiveNotifications")
data class TdUpdateActiveNotifications(
    @SerialName("groups")
    val groups: List<TdNotificationGroup>
) : TdUpdate
