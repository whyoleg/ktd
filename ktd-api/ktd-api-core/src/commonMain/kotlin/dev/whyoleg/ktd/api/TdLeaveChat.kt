package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes current user from chat members
 * Private and secret chats can't be left using this method
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("leaveChat")
data class TdLeaveChat(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdLeaveChat {
        return copy(extra = extra.copy(id = id))
    }
}
