package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * The content of a message to send
 */
@Serializable
sealed class TdInputMessageContent : TdObject {
    /**
     * A text message
     *
     * @property text Formatted text to be sent
     *                1-GetOption("message_text_length_max") characters
     *                Only Bold, Italic, Underline, Strikethrough, Code, Pre, PreCode, TextUrl and MentionName entities are allowed to be specified manually
     * @property disableWebPagePreview True, if rich web page previews for URLs in the message text should be disabled
     * @property clearDraft True, if a chat message draft should be deleted
     */
    @Serializable
    @SerialName("inputMessageText")
    data class InputMessageText(
        @SerialName("text")
        val text: TdFormattedText,
        @SerialName("disable_web_page_preview")
        val disableWebPagePreview: Boolean,
        @SerialName("clear_draft")
        val clearDraft: Boolean
    ) : TdInputMessageContent()

    /**
     * An animation message (GIF-style).
     *
     * @property animation Animation file to be sent
     * @property thumbnail Animation thumbnail, if available
     * @property duration Duration of the animation, in seconds
     * @property width Width of the animation
     *                 May be replaced by the server
     * @property height Height of the animation
     *                  May be replaced by the server
     * @property caption Animation caption
     *                   0-GetOption("message_caption_length_max") characters
     */
    @Serializable
    @SerialName("inputMessageAnimation")
    data class InputMessageAnimation(
        @SerialName("animation")
        val animation: TdInputFile,
        @SerialName("thumbnail")
        val thumbnail: TdInputThumbnail,
        @SerialName("duration")
        val duration: Int,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("caption")
        val caption: TdFormattedText
    ) : TdInputMessageContent()

    /**
     * An audio message
     *
     * @property audio Audio file to be sent
     * @property albumCoverThumbnail Thumbnail of the cover for the album, if available
     * @property duration Duration of the audio, in seconds
     *                    May be replaced by the server
     * @property title Title of the audio
     *                 May be replaced by the server
     * @property performer Performer of the audio
     * @property caption Audio caption
     *                   0-GetOption("message_caption_length_max") characters
     */
    @Serializable
    @SerialName("inputMessageAudio")
    data class InputMessageAudio(
        @SerialName("audio")
        val audio: TdInputFile,
        @SerialName("album_cover_thumbnail")
        val albumCoverThumbnail: TdInputThumbnail,
        @SerialName("duration")
        val duration: Int,
        @SerialName("title")
        val title: String,
        @SerialName("performer")
        val performer: String,
        @SerialName("caption")
        val caption: TdFormattedText
    ) : TdInputMessageContent()

    /**
     * A document message (general file)
     *
     * @property document Document to be sent
     * @property thumbnail Document thumbnail, if available
     * @property caption Document caption
     *                   0-GetOption("message_caption_length_max") characters
     */
    @Serializable
    @SerialName("inputMessageDocument")
    data class InputMessageDocument(
        @SerialName("document")
        val document: TdInputFile,
        @SerialName("thumbnail")
        val thumbnail: TdInputThumbnail,
        @SerialName("caption")
        val caption: TdFormattedText
    ) : TdInputMessageContent()

    /**
     * A photo message
     *
     * @property photo Photo to send
     * @property thumbnail Photo thumbnail to be sent, this is sent to the other party in secret chats only
     * @property addedStickerFileIds File identifiers of the stickers added to the photo, if applicable
     * @property width Photo width
     * @property height Photo height
     * @property caption Photo caption
     *                   0-GetOption("message_caption_length_max") characters
     * @property ttl Photo TTL (Time To Live), in seconds (0-60)
     *               A non-zero TTL can be specified only in private chats
     */
    @Serializable
    @SerialName("inputMessagePhoto")
    data class InputMessagePhoto(
        @SerialName("photo")
        val photo: TdInputFile,
        @SerialName("thumbnail")
        val thumbnail: TdInputThumbnail,
        @SerialName("added_sticker_file_ids")
        val addedStickerFileIds: IntArray,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("caption")
        val caption: TdFormattedText,
        @SerialName("ttl")
        val ttl: Int
    ) : TdInputMessageContent()

    /**
     * A sticker message
     *
     * @property sticker Sticker to be sent
     * @property thumbnail Sticker thumbnail, if available
     * @property width Sticker width
     * @property height Sticker height
     */
    @Serializable
    @SerialName("inputMessageSticker")
    data class InputMessageSticker(
        @SerialName("sticker")
        val sticker: TdInputFile,
        @SerialName("thumbnail")
        val thumbnail: TdInputThumbnail,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int
    ) : TdInputMessageContent()

    /**
     * A video message
     *
     * @property video Video to be sent
     * @property thumbnail Video thumbnail, if available
     * @property addedStickerFileIds File identifiers of the stickers added to the video, if applicable
     * @property duration Duration of the video, in seconds
     * @property width Video width
     * @property height Video height
     * @property supportsStreaming True, if the video should be tried to be streamed
     * @property caption Video caption
     *                   0-GetOption("message_caption_length_max") characters
     * @property ttl Video TTL (Time To Live), in seconds (0-60)
     *               A non-zero TTL can be specified only in private chats
     */
    @Serializable
    @SerialName("inputMessageVideo")
    data class InputMessageVideo(
        @SerialName("video")
        val video: TdInputFile,
        @SerialName("thumbnail")
        val thumbnail: TdInputThumbnail,
        @SerialName("added_sticker_file_ids")
        val addedStickerFileIds: IntArray,
        @SerialName("duration")
        val duration: Int,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("supports_streaming")
        val supportsStreaming: Boolean,
        @SerialName("caption")
        val caption: TdFormattedText,
        @SerialName("ttl")
        val ttl: Int
    ) : TdInputMessageContent()

    /**
     * A video note message
     *
     * @property videoNote Video note to be sent
     * @property thumbnail Video thumbnail, if available
     * @property duration Duration of the video, in seconds
     * @property length Video width and height
     *                  Must be positive and not greater than 640
     */
    @Serializable
    @SerialName("inputMessageVideoNote")
    data class InputMessageVideoNote(
        @SerialName("video_note")
        val videoNote: TdInputFile,
        @SerialName("thumbnail")
        val thumbnail: TdInputThumbnail,
        @SerialName("duration")
        val duration: Int,
        @SerialName("length")
        val length: Int
    ) : TdInputMessageContent()

    /**
     * A voice note message
     *
     * @property voiceNote Voice note to be sent
     * @property duration Duration of the voice note, in seconds
     * @property waveform Waveform representation of the voice note, in 5-bit format
     * @property caption Voice note caption
     *                   0-GetOption("message_caption_length_max") characters
     */
    @Serializable
    @SerialName("inputMessageVoiceNote")
    data class InputMessageVoiceNote(
        @SerialName("voice_note")
        val voiceNote: TdInputFile,
        @SerialName("duration")
        val duration: Int,
        @SerialName("waveform")
        val waveform: ByteArray,
        @SerialName("caption")
        val caption: TdFormattedText
    ) : TdInputMessageContent()

    /**
     * A message with a location
     *
     * @property location Location to be sent
     * @property livePeriod Period for which the location can be updated, in seconds
     *                      Should be between 60 and 86400 for a live location and 0 otherwise
     */
    @Serializable
    @SerialName("inputMessageLocation")
    data class InputMessageLocation(
        @SerialName("location")
        val location: TdLocation,
        @SerialName("live_period")
        val livePeriod: Int
    ) : TdInputMessageContent()

    /**
     * A message with information about a venue
     *
     * @property venue Venue to send
     */
    @Serializable
    @SerialName("inputMessageVenue")
    data class InputMessageVenue(
        @SerialName("venue")
        val venue: TdVenue
    ) : TdInputMessageContent()

    /**
     * A message containing a user contact
     *
     * @property contact Contact to send
     */
    @Serializable
    @SerialName("inputMessageContact")
    data class InputMessageContact(
        @SerialName("contact")
        val contact: TdContact
    ) : TdInputMessageContent()

    /**
     * A message with a game
     * Not supported for channels or secret chats
     *
     * @property botUserId User identifier of the bot that owns the game
     * @property gameShortName Short name of the game
     */
    @Serializable
    @SerialName("inputMessageGame")
    data class InputMessageGame(
        @SerialName("bot_user_id")
        val botUserId: Int,
        @SerialName("game_short_name")
        val gameShortName: String
    ) : TdInputMessageContent()

    /**
     * A message with a poll
     * Polls can't be sent to secret chats
     * Polls can be sent only to a private chat with a bot
     *
     * @property question Poll question, 1-255 characters
     * @property options List of poll answer options, 2-10 strings 1-100 characters each
     * @property isAnonymous True, if the poll voters are anonymous
     *                       Non-anonymous polls can't be sent or forwarded to channels
     * @property type Type of the poll
     * @property isClosed True, if the poll needs to be sent already closed
     */
    @Serializable
    @SerialName("inputMessagePoll")
    data class InputMessagePoll(
        @SerialName("question")
        val question: String,
        @SerialName("options")
        val options: List<String>,
        @SerialName("is_anonymous")
        val isAnonymous: Boolean,
        @SerialName("type")
        val type: TdPollType,
        @SerialName("is_closed")
        @TdBotsOnly
        val isClosed: Boolean
    ) : TdInputMessageContent()

    /**
     * A forwarded message
     *
     * @property fromChatId Identifier for the chat this forwarded message came from
     * @property messageId Identifier of the message to forward
     * @property inGameShare True, if a game message should be shared within a launched game
     *                       Applies only to game messages
     * @property sendCopy True, if content of the message needs to be copied without a link to the original message
     *                    Always true if the message is forwarded to a secret chat
     * @property removeCaption True, if media caption of the message copy needs to be removed
     *                         Ignored if send_copy is false
     */
    @Serializable
    @SerialName("inputMessageForwarded")
    data class InputMessageForwarded(
        @SerialName("from_chat_id")
        val fromChatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("in_game_share")
        val inGameShare: Boolean,
        @SerialName("send_copy")
        val sendCopy: Boolean,
        @SerialName("remove_caption")
        val removeCaption: Boolean
    ) : TdInputMessageContent()
}
