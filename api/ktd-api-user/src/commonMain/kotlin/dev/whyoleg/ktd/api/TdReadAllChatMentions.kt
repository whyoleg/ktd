package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Marks all mentions in a chat as read
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("readAllChatMentions")
data class TdReadAllChatMentions(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdReadAllChatMentions {
        return copy(extra = extra.copy(id = id))
    }
}
