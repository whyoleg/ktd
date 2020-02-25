package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Edits information about a custom local language pack in the current localization target
 * Can be called before authorization
 *
 * @property info New information about the custom local language pack
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("editCustomLanguagePackInfo")
data class TdEditCustomLanguagePackInfo(
    @SerialName("info")
    val info: TdLanguagePackInfo? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEditCustomLanguagePackInfo {
        return copy(extra = extra.copy(id = id))
    }
}
