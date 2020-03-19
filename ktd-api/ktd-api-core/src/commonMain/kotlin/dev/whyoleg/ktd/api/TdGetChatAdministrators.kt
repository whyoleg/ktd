package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a list of administrators of the chat with their custom titles
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getChatAdministrators")
data class TdGetChatAdministrators(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChatAdministrators> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetChatAdministrators {
        return copy(extra = extra.copy(id = id))
    }
}
