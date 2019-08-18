@file:Suppress("unused")

package dev.whyoleg.ktd.api.localization

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about the current localization target. This is an offline request if onlyLocal is true. Can be called before authorization
 *
 * @onlyLocal - If true, returns only locally available information without sending network requests
 */
suspend fun TelegramClient.getLocalizationTargetInfo(
    onlyLocal: Boolean
): LocalizationTargetInfo = localization(
    GetLocalizationTargetInfo(
        onlyLocal
    )
)
