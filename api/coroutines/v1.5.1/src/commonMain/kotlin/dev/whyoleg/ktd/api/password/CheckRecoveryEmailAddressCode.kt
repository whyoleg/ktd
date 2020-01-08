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
 * Checks the 2-step verification recovery email address verification code
 *
 * @code - Verification code
 */
suspend fun TelegramClient.checkRecoveryEmailAddressCode(
    code: String? = null
): PasswordState = password(
    CheckRecoveryEmailAddressCode(
        code
    )
)

/**
 * Checks the 2-step verification recovery email address verification code
 */
suspend fun TelegramClient.password(
    f: CheckRecoveryEmailAddressCode
): PasswordState = exec(f) as PasswordState
