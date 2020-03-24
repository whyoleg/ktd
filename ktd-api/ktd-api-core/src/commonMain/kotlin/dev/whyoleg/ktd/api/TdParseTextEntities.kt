package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Parses Bold, Italic, Underline, Strikethrough, Code, Pre, PreCode, TextUrl and MentionName entities contained in the text
 * This is an offline method
 * Can be called before authorization
 *
 * @property text The text which should be parsed
 * @property parseMode Text parse mode
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("parseTextEntities")
data class TdParseTextEntities(
    @SerialName("text")
    val text: String? = null,
    @SerialName("parse_mode")
    val parseMode: TdTextParseMode? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdFormattedText> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdParseTextEntities {
        return copy(extra = extra.copy(id = id))
    }
}
