package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the location of a chat
 * Available only for some location-based supergroups, use supergroupFullInfo.can_set_location to check whether the method is allowed to use
 *
 * @property chatId Chat identifier
 * @property location New location for the chat
 *                    Must be valid and not null
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setChatLocation")
data class TdSetChatLocation(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("location")
    val location: TdChatLocation? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetChatLocation {
        return copy(extra = extra.copy(id = id))
    }
}
