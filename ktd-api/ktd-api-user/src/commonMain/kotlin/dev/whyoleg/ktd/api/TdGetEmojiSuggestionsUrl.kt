package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns an HTTP URL which can be used to automatically log in to the translation platform and suggest new emoji replacements
 * The URL will be valid for 30 seconds after generation
 *
 * @property languageCode Language code for which the emoji replacements will be suggested
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getEmojiSuggestionsUrl")
data class TdGetEmojiSuggestionsUrl(
    @SerialName("language_code")
    val languageCode: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdHttpUrl> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetEmojiSuggestionsUrl {
        return copy(extra = extra.copy(id = id))
    }
}
