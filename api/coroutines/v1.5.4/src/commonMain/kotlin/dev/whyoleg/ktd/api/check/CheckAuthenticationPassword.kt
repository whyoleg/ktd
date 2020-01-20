@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.check

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Checks the authentication password for correctness
 * Works only when the current authorization state is authorizationStateWaitPassword
 *
 * @password - The password to check
 */
suspend fun TelegramClient.checkAuthenticationPassword(
    password: String? = null
): Ok = check(
    CheckAuthenticationPassword(
        password
    )
)

/**
 * Checks the authentication password for correctness
 * Works only when the current authorization state is authorizationStateWaitPassword
 */
suspend fun TelegramClient.check(
    f: CheckAuthenticationPassword
): Ok = exec(f) as Ok
