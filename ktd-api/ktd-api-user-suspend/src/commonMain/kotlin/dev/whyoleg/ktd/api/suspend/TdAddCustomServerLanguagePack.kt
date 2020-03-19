package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds a custom server language pack to the list of installed language packs in current localization target
 * Can be called before authorization
 *
 * @property languagePackId Identifier of a language pack to be added
 *                          May be different from a name that is used in an "https://t.me/setlanguage/" link
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.addCustomServerLanguagePack(languagePackId: String? = null,
        extra: TdExtra = TdExtra.EMPTY): TdOk = exec(TdAddCustomServerLanguagePack(languagePackId,
        extra))
