package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds a chat to the list of recently found chats
 * The chat is added to the beginning of the list
 * If the chat is already in the list, it will be removed from the list first
 *
 * @property chatId Identifier of the chat to add
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("addRecentlyFoundChat")
data class TdAddRecentlyFoundChat(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAddRecentlyFoundChat {
        return copy(extra = extra.copy(id = id))
    }
}
