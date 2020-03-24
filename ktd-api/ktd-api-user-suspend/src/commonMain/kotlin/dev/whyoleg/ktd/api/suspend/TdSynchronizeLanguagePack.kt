package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Fetches the latest versions of all strings from a language pack in the current localization target from the server
 * This method doesn't need to be called explicitly for the current used/base language packs
 * Can be called before authorization
 *
 * @property languagePackId Language pack identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.synchronizeLanguagePack(languagePackId: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdSynchronizeLanguagePack(languagePackId, extra))
