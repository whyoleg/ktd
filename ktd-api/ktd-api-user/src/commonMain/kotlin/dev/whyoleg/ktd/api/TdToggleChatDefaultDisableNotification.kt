package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the value of the default disable_notification parameter, used when a message is sent to a chat
 *
 * @property chatId Chat identifier
 * @property defaultDisableNotification New value of default_disable_notification
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("toggleChatDefaultDisableNotification")
data class TdToggleChatDefaultDisableNotification(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("default_disable_notification")
    val defaultDisableNotification: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdToggleChatDefaultDisableNotification {
        return copy(extra = extra.copy(id = id))
    }
}
