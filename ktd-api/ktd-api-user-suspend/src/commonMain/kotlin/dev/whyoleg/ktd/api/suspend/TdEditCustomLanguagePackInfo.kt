package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits information about a custom local language pack in the current localization target
 * Can be called before authorization
 *
 * @property info New information about the custom local language pack
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editCustomLanguagePackInfo(info: TdLanguagePackInfo? = null,
        extra: TdExtra = TdExtra.EMPTY): TdOk = exec(TdEditCustomLanguagePackInfo(info, extra))
