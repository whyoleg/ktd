package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the way the text should be parsed for TextEntities
 */
@Serializable
sealed class TdTextParseMode : TdObject {
    /**
     * The text should be parsed in markdown-style
     *
     * @property version Version of the parser: 0 or 1 - Bot API Markdown parse mode, 2 - Bot API MarkdownV2 parse mode
     */
    @Serializable
    @SerialName("textParseModeMarkdown")
    data class Markdown(
        @SerialName("version")
        val version: Int
    ) : TdTextParseMode()

    /**
     * The text should be parsed in HTML-style
     */
    @Serializable
    @SerialName("textParseModeHTML")
    object HTML : TdTextParseMode()
}
