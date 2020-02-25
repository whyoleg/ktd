package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a list of public chats of the specified type, owned by the user
 *
 * @property type Type of the public chats to return
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getCreatedPublicChats")
data class TdGetCreatedPublicChats(
    @SerialName("type")
    val type: TdPublicChatType? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChats> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetCreatedPublicChats {
        return copy(extra = extra.copy(id = id))
    }
}
