package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a single member of a chat
 *
 * @property chatId Chat identifier
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getChatMember")
data class TdGetChatMember(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChatMember> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetChatMember {
        return copy(extra = extra.copy(id = id))
    }
}
