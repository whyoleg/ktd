package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

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
suspend fun SuspendTdClient.getLanguagePackString(
    languagePackDatabasePath: String? = null,
    localizationTarget: String? = null,
    languagePackId: String? = null,
    key: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdLanguagePackStringValue = exec(TdGetLanguagePackString(languagePackDatabasePath,
        localizationTarget, languagePackId, key, extra))
