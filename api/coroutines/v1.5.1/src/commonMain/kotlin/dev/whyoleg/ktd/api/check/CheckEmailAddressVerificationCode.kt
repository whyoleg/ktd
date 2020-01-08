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
 * Checks the email address verification code for Telegram Passport
 *
 * @code - Verification code
 */
suspend fun TelegramClient.checkEmailAddressVerificationCode(
    code: String? = null
): Ok = check(
    CheckEmailAddressVerificationCode(
        code
    )
)

/**
 * Checks the email address verification code for Telegram Passport
 */
suspend fun TelegramClient.check(
    f: CheckEmailAddressVerificationCode
): Ok = exec(f) as Ok
