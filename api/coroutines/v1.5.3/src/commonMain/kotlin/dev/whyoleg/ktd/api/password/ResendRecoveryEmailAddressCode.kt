@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.password

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Resends the 2-step verification recovery email address verification code
 */
suspend fun TelegramClient.resendRecoveryEmailAddressCode(): PasswordState = password(
    ResendRecoveryEmailAddressCode()
)

/**
 * Resends the 2-step verification recovery email address verification code
 */
suspend fun TelegramClient.password(
    f: ResendRecoveryEmailAddressCode
): PasswordState = exec(f) as PasswordState
