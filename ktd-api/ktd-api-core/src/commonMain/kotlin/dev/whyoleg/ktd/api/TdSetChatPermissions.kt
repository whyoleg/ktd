package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the chat members permissions
 * Supported only for basic groups and supergroups
 * Requires can_restrict_members administrator right
 *
 * @property chatId Chat identifier
 * @property permissions New non-administrator members permissions in the chat
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setChatPermissions")
data class TdSetChatPermissions(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("permissions")
    val permissions: TdChatPermissions? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetChatPermissions {
        return copy(extra = extra.copy(id = id))
    }
}
