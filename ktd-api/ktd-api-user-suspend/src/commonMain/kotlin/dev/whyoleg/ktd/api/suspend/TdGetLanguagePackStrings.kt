package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns strings from a language pack in the current localization target by their keys
 * Can be called before authorization
 *
 * @property languagePackId Language pack identifier of the strings to be returned
 * @property keys Language pack keys of the strings to be returned
 *                Leave empty to request all available strings
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getLanguagePackStrings(
    languagePackId: String? = null,
    keys: List<String> = emptyList(),
    extra: TdExtra = TdExtra.EMPTY
): TdLanguagePackStrings = exec(TdGetLanguagePackStrings(languagePackId, keys, extra))
