package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Deletes all information about a language pack in the current localization target
 * The language pack which is currently in use (including base language pack) or is being synchronized can't be deleted
 * Can be called before authorization
 *
 * @property languagePackId Identifier of the language pack to delete
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.deleteLanguagePack(languagePackId: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdDeleteLanguagePack(languagePackId, extra))
