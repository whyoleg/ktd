package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a single result of an inline query
 */
@Serializable
sealed class TdInlineQueryResult : TdObject {
    /**
     * Represents a link to an article or web page
     *
     * @property id Unique identifier of the query result
     * @property url URL of the result, if it exists
     * @property hideUrl True, if the URL must be not shown
     * @property title Title of the result
     * @property description A short description of the result
     * @property thumbnail Result thumbnail
     */
    @Serializable
    @SerialName("inlineQueryResultArticle")
    data class Article(
        @SerialName("id")
        val id: String,
        @SerialName("url")
        val url: String,
        @SerialName("hide_url")
        val hideUrl: Boolean,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String,
        @SerialName("thumbnail")
        val thumbnail: TdPhotoSize?
    ) : TdInlineQueryResult()

    /**
     * Represents a user contact
     *
     * @property id Unique identifier of the query result
     * @property contact A user contact
     * @property thumbnail Result thumbnail
     */
    @Serializable
    @SerialName("inlineQueryResultContact")
    data class Contact(
        @SerialName("id")
        val id: String,
        @SerialName("contact")
        val contact: TdContact,
        @SerialName("thumbnail")
        val thumbnail: TdPhotoSize?
    ) : TdInlineQueryResult()

    /**
     * Represents a point on the map
     *
     * @property id Unique identifier of the query result
     * @property location Location result
     * @property title Title of the result
     * @property thumbnail Result thumbnail
     */
    @Serializable
    @SerialName("inlineQueryResultLocation")
    data class Location(
        @SerialName("id")
        val id: String,
        @SerialName("location")
        val location: TdLocation,
        @SerialName("title")
        val title: String,
        @SerialName("thumbnail")
        val thumbnail: TdPhotoSize?
    ) : TdInlineQueryResult()

    /**
     * Represents information about a venue
     *
     * @property id Unique identifier of the query result
     * @property venue Venue result
     * @property thumbnail Result thumbnail
     */
    @Serializable
    @SerialName("inlineQueryResultVenue")
    data class Venue(
        @SerialName("id")
        val id: String,
        @SerialName("venue")
        val venue: TdVenue,
        @SerialName("thumbnail")
        val thumbnail: TdPhotoSize?
    ) : TdInlineQueryResult()

    /**
     * Represents information about a game
     *
     * @property id Unique identifier of the query result
     * @property game Game result
     */
    @Serializable
    @SerialName("inlineQueryResultGame")
    data class Game(
        @SerialName("id")
        val id: String,
        @SerialName("game")
        val game: TdGame
    ) : TdInlineQueryResult()

    /**
     * Represents an animation file
     *
     * @property id Unique identifier of the query result
     * @property animation Animation file
     * @property title Animation title
     */
    @Serializable
    @SerialName("inlineQueryResultAnimation")
    data class Animation(
        @SerialName("id")
        val id: String,
        @SerialName("animation")
        val animation: TdAnimation,
        @SerialName("title")
        val title: String
    ) : TdInlineQueryResult()

    /**
     * Represents an audio file
     *
     * @property id Unique identifier of the query result
     * @property audio Audio file
     */
    @Serializable
    @SerialName("inlineQueryResultAudio")
    data class Audio(
        @SerialName("id")
        val id: String,
        @SerialName("audio")
        val audio: TdAudio
    ) : TdInlineQueryResult()

    /**
     * Represents a document
     *
     * @property id Unique identifier of the query result
     * @property document Document
     * @property title Document title
     * @property description Document description
     */
    @Serializable
    @SerialName("inlineQueryResultDocument")
    data class Document(
        @SerialName("id")
        val id: String,
        @SerialName("document")
        val document: TdDocument,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String
    ) : TdInlineQueryResult()

    /**
     * Represents a photo
     *
     * @property id Unique identifier of the query result
     * @property photo Photo
     * @property title Title of the result, if known
     * @property description A short description of the result, if known
     */
    @Serializable
    @SerialName("inlineQueryResultPhoto")
    data class Photo(
        @SerialName("id")
        val id: String,
        @SerialName("photo")
        val photo: TdPhoto,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String
    ) : TdInlineQueryResult()

    /**
     * Represents a sticker
     *
     * @property id Unique identifier of the query result
     * @property sticker Sticker
     */
    @Serializable
    @SerialName("inlineQueryResultSticker")
    data class Sticker(
        @SerialName("id")
        val id: String,
        @SerialName("sticker")
        val sticker: TdSticker
    ) : TdInlineQueryResult()

    /**
     * Represents a video
     *
     * @property id Unique identifier of the query result
     * @property video Video
     * @property title Title of the video
     * @property description Description of the video
     */
    @Serializable
    @SerialName("inlineQueryResultVideo")
    data class Video(
        @SerialName("id")
        val id: String,
        @SerialName("video")
        val video: TdVideo,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String
    ) : TdInlineQueryResult()

    /**
     * Represents a voice note
     *
     * @property id Unique identifier of the query result
     * @property voiceNote Voice note
     * @property title Title of the voice note
     */
    @Serializable
    @SerialName("inlineQueryResultVoiceNote")
    data class VoiceNote(
        @SerialName("id")
        val id: String,
        @SerialName("voice_note")
        val voiceNote: TdVoiceNote,
        @SerialName("title")
        val title: String
    ) : TdInlineQueryResult()
}
