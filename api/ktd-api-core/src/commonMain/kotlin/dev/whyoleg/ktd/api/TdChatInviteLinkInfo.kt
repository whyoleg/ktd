package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a chat invite link
 *
 * @property chatId Chat identifier of the invite link
 *                  0 if the user is not a member of this chat
 * @property type Contains information about the type of the chat
 * @property title Title of the chat
 * @property photo Chat photo
 * @property memberCount Number of members
 * @property memberUserIds User identifiers of some chat members that may be known to the current user
 * @property isPublic True, if the chat is a public supergroup or channel, i.e
 *                    It has a username or it is a location-based supergroup
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("chatInviteLinkInfo")
data class TdChatInviteLinkInfo(
    @SerialName("chat_id")
    val chatId: Long,
    @SerialName("type")
    val type: TdChatType,
    @SerialName("title")
    val title: String,
    @SerialName("photo")
    val photo: TdChatPhoto?,
    @SerialName("member_count")
    val memberCount: Int,
    @SerialName("member_user_ids")
    val memberUserIds: IntArray,
    @SerialName("is_public")
    val isPublic: Boolean,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
