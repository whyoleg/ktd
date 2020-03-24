package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Informs TDLib that the chat is opened by the user
 * Many useful activities depend on the chat being opened or closed (e.g., in supergroups and channels all updates are received only for opened chats)
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("openChat")
data class TdOpenChat(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdOpenChat {
        return copy(extra = extra.copy(id = id))
    }
}
