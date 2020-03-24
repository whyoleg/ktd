package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a part of the text which must be formatted differently
 */
@Serializable
sealed class TdTextEntityType : TdObject {
    /**
     * A mention of a user by their username
     */
    @Serializable
    @SerialName("textEntityTypeMention")
    object Mention : TdTextEntityType()

    /**
     * A hashtag text, beginning with "#"
     */
    @Serializable
    @SerialName("textEntityTypeHashtag")
    object Hashtag : TdTextEntityType()

    /**
     * A cashtag text, beginning with "$" and consisting of capital english letters (i.e
     * "$USD")
     */
    @Serializable
    @SerialName("textEntityTypeCashtag")
    object Cashtag : TdTextEntityType()

    /**
     * A bot command, beginning with "/"
     * This shouldn't be highlighted if there are no bots in the chat
     */
    @Serializable
    @SerialName("textEntityTypeBotCommand")
    object BotCommand : TdTextEntityType()

    /**
     * An HTTP URL
     */
    @Serializable
    @SerialName("textEntityTypeUrl")
    object Url : TdTextEntityType()

    /**
     * An email address
     */
    @Serializable
    @SerialName("textEntityTypeEmailAddress")
    object EmailAddress : TdTextEntityType()

    /**
     * A phone number
     */
    @Serializable
    @SerialName("textEntityTypePhoneNumber")
    object PhoneNumber : TdTextEntityType()

    /**
     * A bold text
     */
    @Serializable
    @SerialName("textEntityTypeBold")
    object Bold : TdTextEntityType()

    /**
     * An italic text
     */
    @Serializable
    @SerialName("textEntityTypeItalic")
    object Italic : TdTextEntityType()

    /**
     * An underlined text
     */
    @Serializable
    @SerialName("textEntityTypeUnderline")
    object Underline : TdTextEntityType()

    /**
     * A strikethrough text
     */
    @Serializable
    @SerialName("textEntityTypeStrikethrough")
    object Strikethrough : TdTextEntityType()

    /**
     * Text that must be formatted as if inside a code HTML tag
     */
    @Serializable
    @SerialName("textEntityTypeCode")
    object Code : TdTextEntityType()

    /**
     * Text that must be formatted as if inside a pre HTML tag
     */
    @Serializable
    @SerialName("textEntityTypePre")
    object Pre : TdTextEntityType()

    /**
     * Text that must be formatted as if inside pre, and code HTML tags
     *
     * @property language Programming language of the code
     *                    As defined by the sender
     */
    @Serializable
    @SerialName("textEntityTypePreCode")
    data class PreCode(
        @SerialName("language")
        val language: String
    ) : TdTextEntityType()

    /**
     * A text description shown instead of a raw URL
     *
     * @property url HTTP or tg:// URL to be opened when the link is clicked
     */
    @Serializable
    @SerialName("textEntityTypeTextUrl")
    data class TextUrl(
        @SerialName("url")
        val url: String
    ) : TdTextEntityType()

    /**
     * A text shows instead of a raw mention of the user (e.g., when the user has no username)
     *
     * @property userId Identifier of the mentioned user
     */
    @Serializable
    @SerialName("textEntityTypeMentionName")
    data class MentionName(
        @SerialName("user_id")
        val userId: Int
    ) : TdTextEntityType()
}
