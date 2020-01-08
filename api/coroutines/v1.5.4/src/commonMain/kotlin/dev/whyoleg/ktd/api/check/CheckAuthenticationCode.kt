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
 * Checks the authentication code
 * Works only when the current authorization state is authorizationStateWaitCode
 *
 * @code - The verification code received via SMS, Telegram message, phone call, or flash call
 */
suspend fun TelegramClient.checkAuthenticationCode(
    code: String? = null
): Ok = check(
    CheckAuthenticationCode(
        code
    )
)

/**
 * Checks the authentication code
 * Works only when the current authorization state is authorizationStateWaitCode
 */
suspend fun TelegramClient.check(
    f: CheckAuthenticationCode
): Ok = exec(f) as Ok
