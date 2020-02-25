package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A user with information about joining/leaving a chat
 *
 * @property userId User identifier of the chat member
 * @property inviterUserId Identifier of a user that invited/promoted/banned this member in the chat
 *                         0 if unknown
 * @property joinedChatDate Point in time (Unix timestamp) when the user joined a chat
 * @property status Status of the member in the chat
 * @property botInfo If the user is a bot, information about the bot
 *                   Can be null even for a bot if the bot is not a chat member
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("chatMember")
data class TdChatMember(
    @SerialName("user_id")
    val userId: Int,
    @SerialName("inviter_user_id")
    val inviterUserId: Int,
    @SerialName("joined_chat_date")
    val joinedChatDate: Int,
    @SerialName("status")
    val status: TdChatMemberStatus,
    @SerialName("bot_info")
    val botInfo: TdBotInfo?,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
