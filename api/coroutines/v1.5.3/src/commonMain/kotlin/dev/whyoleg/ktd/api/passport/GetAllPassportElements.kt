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
 * Returns all available Telegram Passport elements
 *
 * @password - Password of the current user
 */
suspend fun TelegramClient.getAllPassportElements(
    password: String? = null
): PassportElements = passport(
    GetAllPassportElements(
        password
    )
)

/**
 * Returns all available Telegram Passport elements
 */
suspend fun TelegramClient.passport(
    f: GetAllPassportElements
): PassportElements = exec(f) as PassportElements
