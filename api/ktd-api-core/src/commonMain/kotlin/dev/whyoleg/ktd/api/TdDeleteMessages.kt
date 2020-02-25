package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Deletes messages
 *
 * @property chatId Chat identifier
 * @property messageIds Identifiers of the messages to be deleted
 * @property revoke Pass true to try to delete messages for all chat members
 *                  Always true for supergroups, channels and secret chats
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deleteMessages")
data class TdDeleteMessages(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_ids")
    val messageIds: LongArray = longArrayOf(),
    @SerialName("revoke")
    val revoke: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDeleteMessages {
        return copy(extra = extra.copy(id = id))
    }
}
