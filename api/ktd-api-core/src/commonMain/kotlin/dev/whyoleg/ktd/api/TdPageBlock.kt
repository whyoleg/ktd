package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a block of an instant view web page
 */
@Serializable
sealed class TdPageBlock : TdObject {
    /**
     * The title of a page
     *
     * @property title Title
     */
    @Serializable
    @SerialName("pageBlockTitle")
    data class Title(
        @SerialName("title")
        val title: TdRichText
    ) : TdPageBlock()

    /**
     * The subtitle of a page
     *
     * @property subtitle Subtitle
     */
    @Serializable
    @SerialName("pageBlockSubtitle")
    data class Subtitle(
        @SerialName("subtitle")
        val subtitle: TdRichText
    ) : TdPageBlock()

    /**
     * The author and publishing date of a page
     *
     * @property author Author
     * @property publishDate Point in time (Unix timestamp) when the article was published
     *                       0 if unknown
     */
    @Serializable
    @SerialName("pageBlockAuthorDate")
    data class AuthorDate(
        @SerialName("author")
        val author: TdRichText,
        @SerialName("publish_date")
        val publishDate: Int
    ) : TdPageBlock()

    /**
     * A header
     *
     * @property header Header
     */
    @Serializable
    @SerialName("pageBlockHeader")
    data class Header(
        @SerialName("header")
        val header: TdRichText
    ) : TdPageBlock()

    /**
     * A subheader
     *
     * @property subheader Subheader
     */
    @Serializable
    @SerialName("pageBlockSubheader")
    data class Subheader(
        @SerialName("subheader")
        val subheader: TdRichText
    ) : TdPageBlock()

    /**
     * A kicker
     *
     * @property kicker Kicker
     */
    @Serializable
    @SerialName("pageBlockKicker")
    data class Kicker(
        @SerialName("kicker")
        val kicker: TdRichText
    ) : TdPageBlock()

    /**
     * A text paragraph
     *
     * @property text Paragraph text
     */
    @Serializable
    @SerialName("pageBlockParagraph")
    data class Paragraph(
        @SerialName("text")
        val text: TdRichText
    ) : TdPageBlock()

    /**
     * A preformatted text paragraph
     *
     * @property text Paragraph text
     * @property language Programming language for which the text should be formatted
     */
    @Serializable
    @SerialName("pageBlockPreformatted")
    data class Preformatted(
        @SerialName("text")
        val text: TdRichText,
        @SerialName("language")
        val language: String
    ) : TdPageBlock()

    /**
     * The footer of a page
     *
     * @property footer Footer
     */
    @Serializable
    @SerialName("pageBlockFooter")
    data class Footer(
        @SerialName("footer")
        val footer: TdRichText
    ) : TdPageBlock()

    /**
     * An empty block separating a page
     */
    @Serializable
    @SerialName("pageBlockDivider")
    object Divider : TdPageBlock()

    /**
     * An invisible anchor on a page, which can be used in a URL to open the page from the specified anchor
     *
     * @property name Name of the anchor
     */
    @Serializable
    @SerialName("pageBlockAnchor")
    data class Anchor(
        @SerialName("name")
        val name: String
    ) : TdPageBlock()

    /**
     * A list of data blocks
     *
     * @property items The items of the list
     */
    @Serializable
    @SerialName("pageBlockList")
    data class List(
        @SerialName("items")
        val items: kotlin.collections.List<TdPageBlockListItem>
    ) : TdPageBlock()

    /**
     * A block quote
     *
     * @property text Quote text
     * @property credit Quote credit
     */
    @Serializable
    @SerialName("pageBlockBlockQuote")
    data class BlockQuote(
        @SerialName("text")
        val text: TdRichText,
        @SerialName("credit")
        val credit: TdRichText
    ) : TdPageBlock()

    /**
     * A pull quote
     *
     * @property text Quote text
     * @property credit Quote credit
     */
    @Serializable
    @SerialName("pageBlockPullQuote")
    data class PullQuote(
        @SerialName("text")
        val text: TdRichText,
        @SerialName("credit")
        val credit: TdRichText
    ) : TdPageBlock()

    /**
     * An animation
     *
     * @property animation Animation file
     * @property caption Animation caption
     * @property needAutoplay True, if the animation should be played automatically
     */
    @Serializable
    @SerialName("pageBlockAnimation")
    data class Animation(
        @SerialName("animation")
        val animation: TdAnimation?,
        @SerialName("caption")
        val caption: TdPageBlockCaption,
        @SerialName("need_autoplay")
        val needAutoplay: Boolean
    ) : TdPageBlock()

    /**
     * An audio file
     *
     * @property audio Audio file
     * @property caption Audio file caption
     */
    @Serializable
    @SerialName("pageBlockAudio")
    data class Audio(
        @SerialName("audio")
        val audio: TdAudio?,
        @SerialName("caption")
        val caption: TdPageBlockCaption
    ) : TdPageBlock()

    /**
     * A photo
     *
     * @property photo Photo file
     * @property caption Photo caption
     * @property url URL that needs to be opened when the photo is clicked
     */
    @Serializable
    @SerialName("pageBlockPhoto")
    data class Photo(
        @SerialName("photo")
        val photo: TdPhoto?,
        @SerialName("caption")
        val caption: TdPageBlockCaption,
        @SerialName("url")
        val url: String
    ) : TdPageBlock()

    /**
     * A video
     *
     * @property video Video file
     * @property caption Video caption
     * @property needAutoplay True, if the video should be played automatically
     * @property isLooped True, if the video should be looped
     */
    @Serializable
    @SerialName("pageBlockVideo")
    data class Video(
        @SerialName("video")
        val video: TdVideo?,
        @SerialName("caption")
        val caption: TdPageBlockCaption,
        @SerialName("need_autoplay")
        val needAutoplay: Boolean,
        @SerialName("is_looped")
        val isLooped: Boolean
    ) : TdPageBlock()

    /**
     * A voice note
     *
     * @property voiceNote Voice note
     * @property caption Voice note caption
     */
    @Serializable
    @SerialName("pageBlockVoiceNote")
    data class VoiceNote(
        @SerialName("voice_note")
        val voiceNote: TdVoiceNote?,
        @SerialName("caption")
        val caption: TdPageBlockCaption
    ) : TdPageBlock()

    /**
     * A page cover
     *
     * @property cover Cover
     */
    @Serializable
    @SerialName("pageBlockCover")
    data class Cover(
        @SerialName("cover")
        val cover: TdPageBlock
    ) : TdPageBlock()

    /**
     * An embedded web page
     *
     * @property url Web page URL, if available
     * @property html HTML-markup of the embedded page
     * @property posterPhoto Poster photo, if available
     * @property width Block width
     *                 0 if unknown
     * @property height Block height
     *                  0 if unknown
     * @property caption Block caption
     * @property isFullWidth True, if the block should be full width
     * @property allowScrolling True, if scrolling should be allowed
     */
    @Serializable
    @SerialName("pageBlockEmbedded")
    data class Embedded(
        @SerialName("url")
        val url: String,
        @SerialName("html")
        val html: String,
        @SerialName("poster_photo")
        val posterPhoto: TdPhoto?,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("caption")
        val caption: TdPageBlockCaption,
        @SerialName("is_full_width")
        val isFullWidth: Boolean,
        @SerialName("allow_scrolling")
        val allowScrolling: Boolean
    ) : TdPageBlock()

    /**
     * An embedded post
     *
     * @property url Web page URL
     * @property author Post author
     * @property authorPhoto Post author photo
     * @property date Point in time (Unix timestamp) when the post was created
     *                0 if unknown
     * @property pageBlocks Post content
     * @property caption Post caption
     */
    @Serializable
    @SerialName("pageBlockEmbeddedPost")
    data class EmbeddedPost(
        @SerialName("url")
        val url: String,
        @SerialName("author")
        val author: String,
        @SerialName("author_photo")
        val authorPhoto: TdPhoto?,
        @SerialName("date")
        val date: Int,
        @SerialName("page_blocks")
        val pageBlocks: kotlin.collections.List<TdPageBlock>,
        @SerialName("caption")
        val caption: TdPageBlockCaption
    ) : TdPageBlock()

    /**
     * A collage
     *
     * @property pageBlocks Collage item contents
     * @property caption Block caption
     */
    @Serializable
    @SerialName("pageBlockCollage")
    data class Collage(
        @SerialName("page_blocks")
        val pageBlocks: kotlin.collections.List<TdPageBlock>,
        @SerialName("caption")
        val caption: TdPageBlockCaption
    ) : TdPageBlock()

    /**
     * A slideshow
     *
     * @property pageBlocks Slideshow item contents
     * @property caption Block caption
     */
    @Serializable
    @SerialName("pageBlockSlideshow")
    data class Slideshow(
        @SerialName("page_blocks")
        val pageBlocks: kotlin.collections.List<TdPageBlock>,
        @SerialName("caption")
        val caption: TdPageBlockCaption
    ) : TdPageBlock()

    /**
     * A link to a chat
     *
     * @property title Chat title
     * @property photo Chat photo
     * @property username Chat username, by which all other information about the chat should be resolved
     */
    @Serializable
    @SerialName("pageBlockChatLink")
    data class ChatLink(
        @SerialName("title")
        val title: String,
        @SerialName("photo")
        val photo: TdChatPhoto?,
        @SerialName("username")
        val username: String
    ) : TdPageBlock()

    /**
     * A table
     *
     * @property caption Table caption
     * @property cells Table cells
     * @property isBordered True, if the table is bordered
     * @property isStriped True, if the table is striped
     */
    @Serializable
    @SerialName("pageBlockTable")
    data class Table(
        @SerialName("caption")
        val caption: TdRichText,
        @SerialName("cells")
        val cells: kotlin.collections.List<kotlin.collections.List<TdPageBlockTableCell>>,
        @SerialName("is_bordered")
        val isBordered: Boolean,
        @SerialName("is_striped")
        val isStriped: Boolean
    ) : TdPageBlock()

    /**
     * A collapsible block
     *
     * @property header Always visible heading for the block
     * @property pageBlocks Block contents
     * @property isOpen True, if the block is open by default
     */
    @Serializable
    @SerialName("pageBlockDetails")
    data class Details(
        @SerialName("header")
        val header: TdRichText,
        @SerialName("page_blocks")
        val pageBlocks: kotlin.collections.List<TdPageBlock>,
        @SerialName("is_open")
        val isOpen: Boolean
    ) : TdPageBlock()

    /**
     * Related articles
     *
     * @property header Block header
     * @property articles List of related articles
     */
    @Serializable
    @SerialName("pageBlockRelatedArticles")
    data class RelatedArticles(
        @SerialName("header")
        val header: TdRichText,
        @SerialName("articles")
        val articles: kotlin.collections.List<TdPageBlockRelatedArticle>
    ) : TdPageBlock()

    /**
     * A map
     *
     * @property location Location of the map center
     * @property zoom Map zoom level
     * @property width Map width
     * @property height Map height
     * @property caption Block caption
     */
    @Serializable
    @SerialName("pageBlockMap")
    data class Map(
        @SerialName("location")
        val location: TdLocation,
        @SerialName("zoom")
        val zoom: Int,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("caption")
        val caption: TdPageBlockCaption
    ) : TdPageBlock()
}
