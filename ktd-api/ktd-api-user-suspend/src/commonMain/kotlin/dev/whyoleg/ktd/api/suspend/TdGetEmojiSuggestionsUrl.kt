package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns an HTTP URL which can be used to automatically log in to the translation platform and suggest new emoji replacements
 * The URL will be valid for 30 seconds after generation
 *
 * @property languageCode Language code for which the emoji replacements will be suggested
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getEmojiSuggestionsUrl(languageCode: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdHttpUrl = exec(TdGetEmojiSuggestionsUrl(languageCode, extra))
