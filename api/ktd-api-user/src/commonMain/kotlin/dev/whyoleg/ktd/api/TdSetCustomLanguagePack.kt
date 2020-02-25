package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds or changes a custom local language pack to the current localization target
 *
 * @property info Information about the language pack
 *                Language pack ID must start with 'X', consist only of English letters, digits and hyphens, and must not exceed 64 characters
 *                Can be called before authorization
 * @property strings Strings of the new language pack
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setCustomLanguagePack")
data class TdSetCustomLanguagePack(
    @SerialName("info")
    val info: TdLanguagePackInfo? = null,
    @SerialName("strings")
    val strings: List<TdLanguagePackString> = emptyList(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetCustomLanguagePack {
        return copy(extra = extra.copy(id = id))
    }
}
