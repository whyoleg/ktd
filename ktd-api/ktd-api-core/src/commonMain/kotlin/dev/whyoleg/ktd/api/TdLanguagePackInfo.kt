package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a language pack
 *
 * @property id Unique language pack identifier
 * @property baseLanguagePackId Identifier of a base language pack
 *                              If a string is missed in the language pack, then it should be fetched from base language pack
 *                              Unsupported in custom language packs
 * @property name Language name
 * @property nativeName Name of the language in that language
 * @property pluralCode A language code to be used to apply plural forms
 *                      See https://www.unicode.org/cldr/charts/latest/supplemental/language_plural_rules.html for more info
 * @property isOfficial True, if the language pack is official
 * @property isRtl True, if the language pack strings are RTL
 * @property isBeta True, if the language pack is a beta language pack
 * @property isInstalled True, if the language pack is installed by the current user
 * @property totalStringCount Total number of non-deleted strings from the language pack
 * @property translatedStringCount Total number of translated strings from the language pack
 * @property localStringCount Total number of non-deleted strings from the language pack available locally
 * @property translationUrl Link to language translation interface
 *                          Empty for custom local language packs
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("languagePackInfo")
data class TdLanguagePackInfo(
    @SerialName("id")
    val id: String,
    @SerialName("base_language_pack_id")
    val baseLanguagePackId: String?,
    @SerialName("name")
    val name: String,
    @SerialName("native_name")
    val nativeName: String,
    @SerialName("plural_code")
    val pluralCode: String,
    @SerialName("is_official")
    val isOfficial: Boolean,
    @SerialName("is_rtl")
    val isRtl: Boolean,
    @SerialName("is_beta")
    val isBeta: Boolean,
    @SerialName("is_installed")
    val isInstalled: Boolean,
    @SerialName("total_string_count")
    val totalStringCount: Int,
    @SerialName("translated_string_count")
    val translatedStringCount: Int,
    @SerialName("local_string_count")
    val localStringCount: Int,
    @SerialName("translation_url")
    val translationUrl: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
