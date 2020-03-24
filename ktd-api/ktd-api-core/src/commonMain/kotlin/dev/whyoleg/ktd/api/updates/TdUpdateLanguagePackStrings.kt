package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * Some language pack strings have been updated
 *
 * @property localizationTarget Localization target to which the language pack belongs
 * @property languagePackId Identifier of the updated language pack
 * @property strings List of changed language pack strings
 */
@Serializable
@SerialName("updateLanguagePackStrings")
data class TdUpdateLanguagePackStrings(
    @SerialName("localization_target")
    val localizationTarget: String,
    @SerialName("language_pack_id")
    val languagePackId: String,
    @SerialName("strings")
    val strings: List<TdLanguagePackString>
) : TdUpdate
