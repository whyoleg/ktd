package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a text object inside an instant-view web page
 */
@Serializable
sealed class TdRichText : TdObject {
    /**
     * A plain text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextPlain")
    data class Plain(
        @SerialName("text")
        val text: String
    ) : TdRichText()

    /**
     * A bold rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextBold")
    data class Bold(
        @SerialName("text")
        val text: TdRichText
    ) : TdRichText()

    /**
     * An italicized rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextItalic")
    data class Italic(
        @SerialName("text")
        val text: TdRichText
    ) : TdRichText()

    /**
     * An underlined rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextUnderline")
    data class Underline(
        @SerialName("text")
        val text: TdRichText
    ) : TdRichText()

    /**
     * A strikethrough rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextStrikethrough")
    data class Strikethrough(
        @SerialName("text")
        val text: TdRichText
    ) : TdRichText()

    /**
     * A fixed-width rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextFixed")
    data class Fixed(
        @SerialName("text")
        val text: TdRichText
    ) : TdRichText()

    /**
     * A rich text URL link
     *
     * @property text Text
     * @property url URL
     * @property isCached True, if the URL has cached instant view server-side
     */
    @Serializable
    @SerialName("richTextUrl")
    data class Url(
        @SerialName("text")
        val text: TdRichText,
        @SerialName("url")
        val url: String,
        @SerialName("is_cached")
        val isCached: Boolean
    ) : TdRichText()

    /**
     * A rich text email link
     *
     * @property text Text
     * @property emailAddress Email address
     */
    @Serializable
    @SerialName("richTextEmailAddress")
    data class EmailAddress(
        @SerialName("text")
        val text: TdRichText,
        @SerialName("email_address")
        val emailAddress: String
    ) : TdRichText()

    /**
     * A subscript rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextSubscript")
    data class Subscript(
        @SerialName("text")
        val text: TdRichText
    ) : TdRichText()

    /**
     * A superscript rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextSuperscript")
    data class Superscript(
        @SerialName("text")
        val text: TdRichText
    ) : TdRichText()

    /**
     * A marked rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextMarked")
    data class Marked(
        @SerialName("text")
        val text: TdRichText
    ) : TdRichText()

    /**
     * A rich text phone number
     *
     * @property text Text
     * @property phoneNumber Phone number
     */
    @Serializable
    @SerialName("richTextPhoneNumber")
    data class PhoneNumber(
        @SerialName("text")
        val text: TdRichText,
        @SerialName("phone_number")
        val phoneNumber: String
    ) : TdRichText()

    /**
     * A small image inside the text
     *
     * @property document The image represented as a document
     *                    The image can be in GIF, JPEG or PNG format
     * @property width Width of a bounding box in which the image should be shown
     *                 0 if unknown
     * @property height Height of a bounding box in which the image should be shown
     *                  0 if unknown
     */
    @Serializable
    @SerialName("richTextIcon")
    data class Icon(
        @SerialName("document")
        val document: TdDocument,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int
    ) : TdRichText()

    /**
     * A rich text anchor
     *
     * @property text Text
     * @property name Anchor name
     */
    @Serializable
    @SerialName("richTextAnchor")
    data class Anchor(
        @SerialName("text")
        val text: TdRichText,
        @SerialName("name")
        val name: String
    ) : TdRichText()

    /**
     * A concatenation of rich texts
     *
     * @property texts Texts
     */
    @Serializable
    @SerialName("richTexts")
    data class s(
        @SerialName("texts")
        val texts: List<TdRichText>
    ) : TdRichText()
}
