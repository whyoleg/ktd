package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for emojis by keywords
 * Supported only if the file database is enabled
 *
 * @property text Text to search for
 * @property exactMatch True, if only emojis, which exactly match text needs to be returned
 * @property inputLanguageCode IETF language tag of the user's input language
 *                             May be empty if unknown
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchEmojis")
data class TdSearchEmojis(
    @SerialName("text")
    val text: String? = null,
    @SerialName("exact_match")
    val exactMatch: Boolean = false,
    @SerialName("input_language_code")
    val inputLanguageCode: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdEmojis> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchEmojis {
        return copy(extra = extra.copy(id = id))
    }
}
