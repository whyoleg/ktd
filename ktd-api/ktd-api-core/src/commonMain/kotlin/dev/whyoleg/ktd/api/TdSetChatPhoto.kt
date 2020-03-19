package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the photo of a chat
 * Supported only for basic groups, supergroups and channels
 * Requires can_change_info rights
 * The photo will not be changed before request to the server has been completed
 *
 * @property chatId Chat identifier
 * @property photo New chat photo
 *                 You can use a zero InputFileId to delete the chat photo
 *                 Files that are accessible only by HTTP URL are not acceptable
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setChatPhoto")
data class TdSetChatPhoto(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("photo")
    val photo: TdInputFile? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetChatPhoto {
        return copy(extra = extra.copy(id = id))
    }
}
