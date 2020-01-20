@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.authentication

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Re-sends an authentication code to the user
 * Works only when the current authorization state is authorizationStateWaitCode and the next_code_type of the result is not null
 */
suspend fun TelegramClient.resendAuthenticationCode(): Ok = authentication(
    ResendAuthenticationCode()
)

/**
 * Re-sends an authentication code to the user
 * Works only when the current authorization state is authorizationStateWaitCode and the next_code_type of the result is not null
 */
suspend fun TelegramClient.authentication(
    f: ResendAuthenticationCode
): Ok = exec(f) as Ok
