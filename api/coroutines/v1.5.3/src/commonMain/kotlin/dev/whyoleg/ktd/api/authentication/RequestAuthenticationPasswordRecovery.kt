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
 * Requests to send a password recovery code to an email address that was previously set up
 * Works only when the current authorization state is authorizationStateWaitPassword
 */
suspend fun TelegramClient.requestAuthenticationPasswordRecovery(): Ok = authentication(
    RequestAuthenticationPasswordRecovery()
)

/**
 * Requests to send a password recovery code to an email address that was previously set up
 * Works only when the current authorization state is authorizationStateWaitPassword
 */
suspend fun TelegramClient.authentication(
    f: RequestAuthenticationPasswordRecovery
): Ok = exec(f) as Ok
