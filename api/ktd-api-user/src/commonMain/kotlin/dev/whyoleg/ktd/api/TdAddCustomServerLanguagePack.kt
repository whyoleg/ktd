package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds a custom server language pack to the list of installed language packs in current localization target
 * Can be called before authorization
 *
 * @property languagePackId Identifier of a language pack to be added
 *                          May be different from a name that is used in an "https://t.me/setlanguage/" link
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("addCustomServerLanguagePack")
data class TdAddCustomServerLanguagePack(
    @SerialName("language_pack_id")
    val languagePackId: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAddCustomServerLanguagePack {
        return copy(extra = extra.copy(id = id))
    }
}
