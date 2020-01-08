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
 * Checks the phone number verification code for Telegram Passport
 *
 * @code - Verification code
 */
suspend fun TelegramClient.checkPhoneNumberVerificationCode(
    code: String? = null
): Ok = check(
    CheckPhoneNumberVerificationCode(
        code
    )
)

/**
 * Checks the phone number verification code for Telegram Passport
 */
suspend fun TelegramClient.check(
    f: CheckPhoneNumberVerificationCode
): Ok = exec(f) as Ok
