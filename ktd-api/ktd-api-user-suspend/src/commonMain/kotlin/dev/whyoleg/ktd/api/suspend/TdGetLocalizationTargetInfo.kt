package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about the current localization target
 * This is an offline request if only_local is true
 * Can be called before authorization
 *
 * @property onlyLocal If true, returns only locally available information without sending network requests
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getLocalizationTargetInfo(onlyLocal: Boolean = false, extra: TdExtra =
        TdExtra.EMPTY): TdLocalizationTargetInfo = exec(TdGetLocalizationTargetInfo(onlyLocal,
        extra))
