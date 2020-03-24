package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds or changes a custom local language pack to the current localization target
 *
 * @property info Information about the language pack
 *                Language pack ID must start with 'X', consist only of English letters, digits and hyphens, and must not exceed 64 characters
 *                Can be called before authorization
 * @property strings Strings of the new language pack
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setCustomLanguagePack(
    info: TdLanguagePackInfo? = null,
    strings: List<TdLanguagePackString> = emptyList(),
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetCustomLanguagePack(info, strings, extra))
