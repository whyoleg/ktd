package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Reports a chat to the Telegram moderators
 * Supported only for supergroups, channels, or private chats with bots, since other chats can't be checked by moderators, or when the report is done from the chat action bar
 *
 * @property chatId Chat identifier
 * @property reason The reason for reporting the chat
 * @property messageIds Identifiers of reported messages, if any
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("reportChat")
data class TdReportChat(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("reason")
    val reason: TdChatReportReason? = null,
    @SerialName("message_ids")
    val messageIds: LongArray = longArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdReportChat {
        return copy(extra = extra.copy(id = id))
    }
}
