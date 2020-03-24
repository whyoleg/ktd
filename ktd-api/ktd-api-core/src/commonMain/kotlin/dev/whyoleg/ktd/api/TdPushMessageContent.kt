package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains content of a push message notification
 */
@Serializable
sealed class TdPushMessageContent : TdObject {
    /**
     * A general message with hidden content
     *
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentHidden")
    data class Hidden(
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * An animation message (GIF-style).
     *
     * @property animation Message content
     * @property caption Animation caption
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentAnimation")
    data class Animation(
        @SerialName("animation")
        val animation: TdAnimation?,
        @SerialName("caption")
        val caption: String,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * An audio message
     *
     * @property audio Message content
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentAudio")
    data class Audio(
        @SerialName("audio")
        val audio: TdAudio?,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A message with a user contact
     *
     * @property name Contact's name
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentContact")
    data class Contact(
        @SerialName("name")
        val name: String,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A contact has registered with Telegram
     */
    @Serializable
    @SerialName("pushMessageContentContactRegistered")
    object ContactRegistered : TdPushMessageContent()

    /**
     * A document message (a general file)
     *
     * @property document Message content
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentDocument")
    data class Document(
        @SerialName("document")
        val document: TdDocument?,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A message with a game
     *
     * @property title Game title, empty for pinned game message
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentGame")
    data class Game(
        @SerialName("title")
        val title: String,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A new high score was achieved in a game
     *
     * @property title Game title, empty for pinned message
     * @property score New score, 0 for pinned message
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentGameScore")
    data class GameScore(
        @SerialName("title")
        val title: String,
        @SerialName("score")
        val score: Int,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A message with an invoice from a bot
     *
     * @property price Product price
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentInvoice")
    data class Invoice(
        @SerialName("price")
        val price: String,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A message with a location
     *
     * @property isLive True, if the location is live
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentLocation")
    data class Location(
        @SerialName("is_live")
        val isLive: Boolean,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A photo message
     *
     * @property photo Message content
     * @property caption Photo caption
     * @property isSecret True, if the photo is secret
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentPhoto")
    data class Photo(
        @SerialName("photo")
        val photo: TdPhoto?,
        @SerialName("caption")
        val caption: String,
        @SerialName("is_secret")
        val isSecret: Boolean,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A message with a poll
     *
     * @property question Poll question
     * @property isRegular True, if the poll is regular and not in quiz mode
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentPoll")
    data class Poll(
        @SerialName("question")
        val question: String,
        @SerialName("is_regular")
        val isRegular: Boolean,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A screenshot of a message in the chat has been taken
     */
    @Serializable
    @SerialName("pushMessageContentScreenshotTaken")
    object ScreenshotTaken : TdPushMessageContent()

    /**
     * A message with a sticker
     *
     * @property sticker Message content
     * @property emoji Emoji corresponding to the sticker
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentSticker")
    data class Sticker(
        @SerialName("sticker")
        val sticker: TdSticker?,
        @SerialName("emoji")
        val emoji: String?,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A text message
     *
     * @property text Message text
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentText")
    data class Text(
        @SerialName("text")
        val text: String,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A video message
     *
     * @property video Message content
     * @property caption Video caption
     * @property isSecret True, if the video is secret
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentVideo")
    data class Video(
        @SerialName("video")
        val video: TdVideo?,
        @SerialName("caption")
        val caption: String,
        @SerialName("is_secret")
        val isSecret: Boolean,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A video note message
     *
     * @property videoNote Message content
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentVideoNote")
    data class VideoNote(
        @SerialName("video_note")
        val videoNote: TdVideoNote?,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A voice note message
     *
     * @property voiceNote Message content
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentVoiceNote")
    data class VoiceNote(
        @SerialName("voice_note")
        val voiceNote: TdVoiceNote?,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : TdPushMessageContent()

    /**
     * A newly created basic group
     */
    @Serializable
    @SerialName("pushMessageContentBasicGroupChatCreate")
    object BasicGroupChatCreate : TdPushMessageContent()

    /**
     * New chat members were invited to a group
     *
     * @property memberName Name of the added member
     * @property isCurrentUser True, if the current user was added to the group
     * @property isReturned True, if the user has returned to the group themself
     */
    @Serializable
    @SerialName("pushMessageContentChatAddMembers")
    data class ChatAddMembers(
        @SerialName("member_name")
        val memberName: String,
        @SerialName("is_current_user")
        val isCurrentUser: Boolean,
        @SerialName("is_returned")
        val isReturned: Boolean
    ) : TdPushMessageContent()

    /**
     * A chat photo was edited
     */
    @Serializable
    @SerialName("pushMessageContentChatChangePhoto")
    object ChatChangePhoto : TdPushMessageContent()

    /**
     * A chat title was edited
     *
     * @property title New chat title
     */
    @Serializable
    @SerialName("pushMessageContentChatChangeTitle")
    data class ChatChangeTitle(
        @SerialName("title")
        val title: String
    ) : TdPushMessageContent()

    /**
     * A chat member was deleted
     *
     * @property memberName Name of the deleted member
     * @property isCurrentUser True, if the current user was deleted from the group
     * @property isLeft True, if the user has left the group themself
     */
    @Serializable
    @SerialName("pushMessageContentChatDeleteMember")
    data class ChatDeleteMember(
        @SerialName("member_name")
        val memberName: String,
        @SerialName("is_current_user")
        val isCurrentUser: Boolean,
        @SerialName("is_left")
        val isLeft: Boolean
    ) : TdPushMessageContent()

    /**
     * A new member joined the chat by invite link
     */
    @Serializable
    @SerialName("pushMessageContentChatJoinByLink")
    object ChatJoinByLink : TdPushMessageContent()

    /**
     * A forwarded messages
     *
     * @property totalCount Number of forwarded messages
     */
    @Serializable
    @SerialName("pushMessageContentMessageForwards")
    data class MessageForwards(
        @SerialName("total_count")
        val totalCount: Int
    ) : TdPushMessageContent()

    /**
     * A media album
     *
     * @property totalCount Number of messages in the album
     * @property hasPhotos True, if the album has at least one photo
     * @property hasVideos True, if the album has at least one video
     */
    @Serializable
    @SerialName("pushMessageContentMediaAlbum")
    data class MediaAlbum(
        @SerialName("total_count")
        val totalCount: Int,
        @SerialName("has_photos")
        val hasPhotos: Boolean,
        @SerialName("has_videos")
        val hasVideos: Boolean
    ) : TdPushMessageContent()
}
