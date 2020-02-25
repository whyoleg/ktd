package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a language pack
 * Returned language pack identifier may be different from a provided one
 * Can be called before authorization
 *
 * @property languagePackId Language pack identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getLanguagePackInfo(languagePackId: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdLanguagePackInfo = exec(TdGetLanguagePackInfo(languagePackId, extra))
