package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns strings from a language pack in the current localization target by their keys
 * Can be called before authorization
 *
 * @property languagePackId Language pack identifier of the strings to be returned
 * @property keys Language pack keys of the strings to be returned
 *                Leave empty to request all available strings
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getLanguagePackStrings")
data class TdGetLanguagePackStrings(
    @SerialName("language_pack_id")
    val languagePackId: String? = null,
    @SerialName("keys")
    val keys: List<String> = emptyList(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdLanguagePackStrings> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetLanguagePackStrings {
        return copy(extra = extra.copy(id = id))
    }
}
