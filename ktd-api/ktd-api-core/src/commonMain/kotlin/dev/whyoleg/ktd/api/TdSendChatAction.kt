package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends a notification about user activity in a chat
 *
 * @property chatId Chat identifier
 * @property action The action description
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendChatAction")
data class TdSendChatAction(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("action")
    val action: TdChatAction? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendChatAction {
        return copy(extra = extra.copy(id = id))
    }
}
