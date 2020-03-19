package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Deletes all information about a language pack in the current localization target
 * The language pack which is currently in use (including base language pack) or is being synchronized can't be deleted
 * Can be called before authorization
 *
 * @property languagePackId Identifier of the language pack to delete
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deleteLanguagePack")
data class TdDeleteLanguagePack(
    @SerialName("language_pack_id")
    val languagePackId: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDeleteLanguagePack {
        return copy(extra = extra.copy(id = id))
    }
}
