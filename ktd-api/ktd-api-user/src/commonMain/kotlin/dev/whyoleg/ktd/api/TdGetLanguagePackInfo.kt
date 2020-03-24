package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a language pack
 * Returned language pack identifier may be different from a provided one
 * Can be called before authorization
 *
 * @property languagePackId Language pack identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getLanguagePackInfo")
data class TdGetLanguagePackInfo(
    @SerialName("language_pack_id")
    val languagePackId: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdLanguagePackInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetLanguagePackInfo {
        return copy(extra = extra.copy(id = id))
    }
}
