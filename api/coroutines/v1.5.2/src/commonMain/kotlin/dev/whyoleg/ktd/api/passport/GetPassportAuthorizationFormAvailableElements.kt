@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.passport

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns already available Telegram Passport elements suitable for completing a Telegram Passport authorization form
 * Result can be received only once for each authorization form
 *
 * @autorizationFormId - Authorization form identifier
 * @password - Password of the current user
 */
suspend fun TelegramClient.getPassportAuthorizationFormAvailableElements(
    autorizationFormId: Int = 0,
    password: String? = null
): PassportElementsWithErrors = passport(
    GetPassportAuthorizationFormAvailableElements(
        autorizationFormId,
        password
    )
)

/**
 * Returns already available Telegram Passport elements suitable for completing a Telegram Passport authorization form
 * Result can be received only once for each authorization form
 */
suspend fun TelegramClient.passport(
    f: GetPassportAuthorizationFormAvailableElements
): PassportElementsWithErrors = exec(f) as PassportElementsWithErrors
