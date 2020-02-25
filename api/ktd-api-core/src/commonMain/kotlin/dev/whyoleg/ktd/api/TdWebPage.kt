package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a web page preview
 *
 * @property url Original URL of the link
 * @property displayUrl URL to display
 * @property type Type of the web page
 *                Can be: article, photo, audio, video, document, profile, app, or something else
 * @property siteName Short name of the site (e.g., Google Docs, App Store)
 * @property title Title of the content
 * @property description Description of the content
 * @property photo Image representing the content
 * @property embedUrl URL to show in the embedded preview
 * @property embedType MIME type of the embedded preview, (e.g., text/html or video/mp4)
 * @property embedWidth Width of the embedded preview
 * @property embedHeight Height of the embedded preview
 * @property duration Duration of the content, in seconds
 * @property author Author of the content
 * @property animation Preview of the content as an animation, if available
 * @property audio Preview of the content as an audio file, if available
 * @property document Preview of the content as a document, if available (currently only available for small PDF files and ZIP archives)
 * @property sticker Preview of the content as a sticker for small WEBP files, if available
 * @property video Preview of the content as a video, if available
 * @property videoNote Preview of the content as a video note, if available
 * @property voiceNote Preview of the content as a voice note, if available
 * @property instantViewVersion Version of instant view, available for the web page (currently can be 1 or 2), 0 if none
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("webPage")
data class TdWebPage(
    @SerialName("url")
    val url: String,
    @SerialName("display_url")
    val displayUrl: String,
    @SerialName("type")
    val type: String,
    @SerialName("site_name")
    val siteName: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("photo")
    val photo: TdPhoto?,
    @SerialName("embed_url")
    val embedUrl: String,
    @SerialName("embed_type")
    val embedType: String,
    @SerialName("embed_width")
    val embedWidth: Int,
    @SerialName("embed_height")
    val embedHeight: Int,
    @SerialName("duration")
    val duration: Int,
    @SerialName("author")
    val author: String,
    @SerialName("animation")
    val animation: TdAnimation?,
    @SerialName("audio")
    val audio: TdAudio?,
    @SerialName("document")
    val document: TdDocument?,
    @SerialName("sticker")
    val sticker: TdSticker?,
    @SerialName("video")
    val video: TdVideo?,
    @SerialName("video_note")
    val videoNote: TdVideoNote?,
    @SerialName("voice_note")
    val voiceNote: TdVoiceNote?,
    @SerialName("instant_view_version")
    val instantViewVersion: Int,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
