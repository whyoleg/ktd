package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes a chat from the list of frequently used chats
 * Supported only if the chat info database is enabled
 *
 * @property category Category of frequently used chats
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeTopChat")
data class TdRemoveTopChat(
    @SerialName("category")
    val category: TdTopChatCategory? = null,
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveTopChat {
        return copy(extra = extra.copy(id = id))
    }
}
