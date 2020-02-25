package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for emojis by keywords
 * Supported only if the file database is enabled
 *
 * @property text Text to search for
 * @property exactMatch True, if only emojis, which exactly match text needs to be returned
 * @property inputLanguageCode IETF language tag of the user's input language
 *                             May be empty if unknown
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchEmojis(
    text: String? = null,
    exactMatch: Boolean = false,
    inputLanguageCode: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdEmojis = exec(TdSearchEmojis(text, exactMatch, inputLanguageCode, extra))
