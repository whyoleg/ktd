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
 * Returns one of the available Telegram Passport elements
 *
 * @type - Telegram Passport element type
 * @password - Password of the current user
 */
suspend fun TelegramClient.getPassportElement(
    type: PassportElementType? = null,
    password: String? = null
): PassportElement = passport(
    GetPassportElement(
        type,
        password
    )
)

/**
 * Returns one of the available Telegram Passport elements
 */
suspend fun TelegramClient.passport(
    f: GetPassportElement
): PassportElement = exec(f) as PassportElement
