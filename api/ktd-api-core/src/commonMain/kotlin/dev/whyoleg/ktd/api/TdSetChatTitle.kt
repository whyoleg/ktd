package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the chat title
 * Supported only for basic groups, supergroups and channels
 * Requires can_change_info rights
 * The title will not be changed until the request to the server has been completed
 *
 * @property chatId Chat identifier
 * @property title New title of the chat
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setChatTitle")
data class TdSetChatTitle(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("title")
    val title: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetChatTitle {
        return copy(extra = extra.copy(id = id))
    }
}
