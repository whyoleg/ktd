package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a message
 *
 * @property id Message identifier, unique for the chat to which the message belongs
 * @property senderUserId Identifier of the user who sent the message
 *                        0 if unknown
 *                        Currently, it is unknown for channel posts and for channel posts automatically forwarded to discussion group
 * @property chatId Chat identifier
 * @property sendingState Information about the sending state of the message
 * @property schedulingState Information about the scheduling state of the message
 * @property isOutgoing True, if the message is outgoing
 * @property canBeEdited True, if the message can be edited
 *                       For live location and poll messages this fields shows whether editMessageLiveLocation or stopPoll can be used with this message by the client
 * @property canBeForwarded True, if the message can be forwarded
 * @property canBeDeletedOnlyForSelf True, if the message can be deleted only for the current user while other users will continue to see it
 * @property canBeDeletedForAllUsers True, if the message can be deleted for all users
 * @property isChannelPost True, if the message is a channel post
 *                         All messages to channels are channel posts, all other messages are not channel posts
 * @property containsUnreadMention True, if the message contains an unread mention for the current user
 * @property date Point in time (Unix timestamp) when the message was sent
 * @property editDate Point in time (Unix timestamp) when the message was last edited
 * @property forwardInfo Information about the initial message sender
 * @property replyToMessageId If non-zero, the identifier of the message this message is replying to
 *                            Can be the identifier of a deleted message
 * @property ttl For self-destructing messages, the message's TTL (Time To Live), in seconds
 *               0 if none
 *               TDLib will send updateDeleteMessages or updateMessageContent once the TTL expires
 * @property ttlExpiresIn Time left before the message expires, in seconds
 * @property viaBotUserId If non-zero, the user identifier of the bot through which this message was sent
 * @property authorSignature For channel posts, optional author signature
 * @property views Number of times this message was viewed
 * @property mediaAlbumId Unique identifier of an album this message belongs to
 *                        Only photos and videos can be grouped together in albums
 * @property restrictionReason If non-empty, contains a human-readable description of the reason why access to this message must be restricted
 * @property content Content of the message
 * @property replyMarkup Reply markup for the message
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("message")
data class TdMessage(
    @SerialName("id")
    val id: Long,
    @SerialName("sender_user_id")
    val senderUserId: Int,
    @SerialName("chat_id")
    val chatId: Long,
    @SerialName("sending_state")
    val sendingState: TdMessageSendingState?,
    @SerialName("scheduling_state")
    val schedulingState: TdMessageSchedulingState?,
    @SerialName("is_outgoing")
    val isOutgoing: Boolean,
    @SerialName("can_be_edited")
    val canBeEdited: Boolean,
    @SerialName("can_be_forwarded")
    val canBeForwarded: Boolean,
    @SerialName("can_be_deleted_only_for_self")
    val canBeDeletedOnlyForSelf: Boolean,
    @SerialName("can_be_deleted_for_all_users")
    val canBeDeletedForAllUsers: Boolean,
    @SerialName("is_channel_post")
    val isChannelPost: Boolean,
    @SerialName("contains_unread_mention")
    val containsUnreadMention: Boolean,
    @SerialName("date")
    val date: Int,
    @SerialName("edit_date")
    val editDate: Int,
    @SerialName("forward_info")
    val forwardInfo: TdMessageForwardInfo?,
    @SerialName("reply_to_message_id")
    val replyToMessageId: Long,
    @SerialName("ttl")
    val ttl: Int,
    @SerialName("ttl_expires_in")
    val ttlExpiresIn: Double,
    @SerialName("via_bot_user_id")
    val viaBotUserId: Int,
    @SerialName("author_signature")
    val authorSignature: String,
    @SerialName("views")
    val views: Int,
    @SerialName("media_album_id")
    val mediaAlbumId: Long,
    @SerialName("restriction_reason")
    val restrictionReason: String,
    @SerialName("content")
    val content: TdMessageContent,
    @SerialName("reply_markup")
    val replyMarkup: TdReplyMarkup?,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
