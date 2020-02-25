package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Fetches the latest versions of all strings from a language pack in the current localization target from the server
 * This method doesn't need to be called explicitly for the current used/base language packs
 * Can be called before authorization
 *
 * @property languagePackId Language pack identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("synchronizeLanguagePack")
data class TdSynchronizeLanguagePack(
    @SerialName("language_pack_id")
    val languagePackId: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSynchronizeLanguagePack {
        return copy(extra = extra.copy(id = id))
    }
}
