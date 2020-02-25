package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a list of frequently used chats
 * Supported only if the chat info database is enabled
 *
 * @property category Category of chats to be returned
 * @property limit The maximum number of chats to be returned
 *                 Up to 30
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getTopChats")
data class TdGetTopChats(
    @SerialName("category")
    val category: TdTopChatCategory? = null,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChats> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetTopChats {
        return copy(extra = extra.copy(id = id))
    }
}
