package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes information about a chat
 * Available for basic groups, supergroups, and channels
 * Requires can_change_info rights
 *
 * @property chatId Identifier of the chat
 * @property description New chat description
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setChatDescription")
data class TdSetChatDescription(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("description")
    val description: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetChatDescription {
        return copy(extra = extra.copy(id = id))
    }
}
