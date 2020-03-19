package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends a notification about a screenshot taken in a chat
 * Supported only in private and secret chats
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendChatScreenshotTakenNotification")
data class TdSendChatScreenshotTakenNotification(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendChatScreenshotTakenNotification {
        return copy(extra = extra.copy(id = id))
    }
}
