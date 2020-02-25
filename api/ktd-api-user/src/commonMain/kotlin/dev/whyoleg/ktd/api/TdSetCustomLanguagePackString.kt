package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds, edits or deletes a string in a custom local language pack
 * Can be called before authorization
 *
 * @property languagePackId Identifier of a previously added custom local language pack in the current localization target
 * @property newString New language pack string
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setCustomLanguagePackString")
data class TdSetCustomLanguagePackString(
    @SerialName("language_pack_id")
    val languagePackId: String? = null,
    @SerialName("new_string")
    val newString: TdLanguagePackString? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetCustomLanguagePackString {
        return copy(extra = extra.copy(id = id))
    }
}
