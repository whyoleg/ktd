package dev.whyoleg.ktd.json

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.json.*
import kotlin.reflect.*

object TdS : TdResponse

inline fun TdS.string(requestId: Long): String = """{"@type":"s","@extra":${requestId}}"""

object TdSSerializer : JsonSerializer<TdS> {
    override val type: String get() = "s"
    override val cls: KClass<TdS> get() = TdS::class
    override val JsonObject.value: TdS get() = TdS
    override fun JsonObjectBuilder.put(value: TdS): Unit = Unit
}

data class TdChat(
    val id: Long,
    val title: String,
    val defaultDisableNotification: Boolean,
    val notificationSettings: TdChatNotificationSettings
) : TdResponse

data class TdChatNotificationSettings(
    val muteFor: Int,
    val sound: String,
    val disableMentionNotifications: Boolean
) : TdResponse

object TdChatNotificationSettingsSerializer : JsonSerializer<TdChatNotificationSettings> {
    override val cls: KClass<TdChatNotificationSettings> get() = TdChatNotificationSettings::class
    override val type: String get() = "chatNotificationSettings"

    override val JsonObject.value: TdChatNotificationSettings
        get() = TdChatNotificationSettings(
            muteFor = getValue("muteFor").int,
            sound = getValue("sound").content,
            disableMentionNotifications = getValue("disableMentionNotifications").boolean
        )

    override fun JsonObjectBuilder.put(value: TdChatNotificationSettings) {
        with(value) {
            "muteFor" to muteFor
            "sound" to sound
            "disableMentionNotifications" to disableMentionNotifications
        }
    }
}

object ChatSerializer : JsonSerializer<TdChat> {
    override val cls: KClass<TdChat> get() = TdChat::class
    override val type: String get() = "chat"

    override val JsonObject.value: TdChat
        get() = TdChat(
            id = getValue("id").long,
            title = getValue("title").content,
            defaultDisableNotification = getValue("defaultDisableNotification").boolean,
            notificationSettings = with(TdChatNotificationSettingsSerializer) { getValue("notificationSettings").jsonObject.value }
        )

    override fun JsonObjectBuilder.put(value: TdChat) {
        with(value) {
            "id" to id
            "title" to title
            "defaultDisableNotification" to defaultDisableNotification
            "notificationSettings" to with(TdChatNotificationSettingsSerializer) { json { put(notificationSettings) } }
        }
    }
}
