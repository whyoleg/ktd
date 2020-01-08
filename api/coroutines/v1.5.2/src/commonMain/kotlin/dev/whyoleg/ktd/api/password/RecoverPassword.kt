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
 * Recovers the password using a recovery code sent to an email address that was previously set up
 *
 * @recoveryCode - Recovery code to check
 */
suspend fun TelegramClient.recoverPassword(
    recoveryCode: String? = null
): PasswordState = password(
    RecoverPassword(
        recoveryCode
    )
)

/**
 * Recovers the password using a recovery code sent to an email address that was previously set up
 */
suspend fun TelegramClient.password(
    f: RecoverPassword
): PasswordState = exec(f) as PasswordState
