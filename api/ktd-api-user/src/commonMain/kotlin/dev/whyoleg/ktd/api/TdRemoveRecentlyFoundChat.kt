package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes a chat from the list of recently found chats
 *
 * @property chatId Identifier of the chat to be removed
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeRecentlyFoundChat")
data class TdRemoveRecentlyFoundChat(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveRecentlyFoundChat {
        return copy(extra = extra.copy(id = id))
    }
}
