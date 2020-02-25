package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds, edits or deletes a string in a custom local language pack
 * Can be called before authorization
 *
 * @property languagePackId Identifier of a previously added custom local language pack in the current localization target
 * @property newString New language pack string
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setCustomLanguagePackString(
    languagePackId: String? = null,
    newString: TdLanguagePackString? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetCustomLanguagePackString(languagePackId, newString, extra))
