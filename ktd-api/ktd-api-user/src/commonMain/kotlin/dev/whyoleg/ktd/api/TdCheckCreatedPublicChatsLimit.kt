package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks whether the maximum number of owned public chats has been reached
 * Returns corresponding error if the limit was reached
 *
 * @property type Type of the public chats, for which to check the limit
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("checkCreatedPublicChatsLimit")
data class TdCheckCreatedPublicChatsLimit(
    @SerialName("type")
    val type: TdPublicChatType? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCheckCreatedPublicChatsLimit {
        return copy(extra = extra.copy(id = id))
    }
}
