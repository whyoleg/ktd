@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.email

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Requests to send a password recovery code to an email address that was previously set up
 */
suspend fun TelegramClient.requestPasswordRecovery(): EmailAddressAuthenticationCodeInfo = email(
    RequestPasswordRecovery()
)

/**
 * Requests to send a password recovery code to an email address that was previously set up
 */
suspend fun TelegramClient.email(
    f: RequestPasswordRecovery
): EmailAddressAuthenticationCodeInfo = exec(f) as EmailAddressAuthenticationCodeInfo
