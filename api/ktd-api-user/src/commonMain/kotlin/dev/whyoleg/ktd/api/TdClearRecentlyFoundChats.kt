package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Clears the list of recently found chats
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("clearRecentlyFoundChats")
data class TdClearRecentlyFoundChats(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdClearRecentlyFoundChats {
        return copy(extra = extra.copy(id = id))
    }
}
