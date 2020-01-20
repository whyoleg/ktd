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
 * Sends a Telegram Passport authorization form, effectively sharing data with the service
 * This method must be called after getPassportAuthorizationFormAvailableElements if some previously available elements need to be used
 *
 * @autorizationFormId - Authorization form identifier
 * @types - Types of Telegram Passport elements chosen by user to complete the authorization form
 */
suspend fun TelegramClient.sendPassportAuthorizationForm(
    autorizationFormId: Int = 0,
    types: Array<PassportElementType> = emptyArray()
): Ok = passport(
    SendPassportAuthorizationForm(
        autorizationFormId,
        types
    )
)

/**
 * Sends a Telegram Passport authorization form, effectively sharing data with the service
 * This method must be called after getPassportAuthorizationFormAvailableElements if some previously available elements need to be used
 */
suspend fun TelegramClient.passport(
    f: SendPassportAuthorizationForm
): Ok = exec(f) as Ok
