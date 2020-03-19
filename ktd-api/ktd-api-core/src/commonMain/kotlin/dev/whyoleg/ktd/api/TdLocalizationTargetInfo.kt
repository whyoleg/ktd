package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about the current localization target
 *
 * @property languagePacks List of available language packs for this application
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("localizationTargetInfo")
data class TdLocalizationTargetInfo(
    @SerialName("language_packs")
    val languagePacks: List<TdLanguagePackInfo>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
