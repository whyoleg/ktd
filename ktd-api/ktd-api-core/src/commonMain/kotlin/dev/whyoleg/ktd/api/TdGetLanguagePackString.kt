package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a string stored in the local database from the specified localization target and language pack by its key
 * Returns a 404 error if the string is not found
 * This is an offline method
 * Can be called before authorization
 *
 * @property languagePackDatabasePath Path to the language pack database in which strings are stored
 * @property localizationTarget Localization target to which the language pack belongs
 * @property languagePackId Language pack identifier
 * @property key Language pack key of the string to be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getLanguagePackString")
data class TdGetLanguagePackString(
    @SerialName("language_pack_database_path")
    val languagePackDatabasePath: String? = null,
    @SerialName("localization_target")
    val localizationTarget: String? = null,
    @SerialName("language_pack_id")
    val languagePackId: String? = null,
    @SerialName("key")
    val key: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdLanguagePackStringValue> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetLanguagePackString {
        return copy(extra = extra.copy(id = id))
    }
}
