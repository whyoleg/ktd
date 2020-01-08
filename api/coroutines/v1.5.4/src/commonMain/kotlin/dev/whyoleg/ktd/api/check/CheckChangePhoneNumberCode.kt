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
 * Checks the authentication code sent to confirm a new phone number of the user
 *
 * @code - Verification code received by SMS, phone call or flash call
 */
suspend fun TelegramClient.checkChangePhoneNumberCode(
    code: String? = null
): Ok = check(
    CheckChangePhoneNumberCode(
        code
    )
)

/**
 * Checks the authentication code sent to confirm a new phone number of the user
 */
suspend fun TelegramClient.check(
    f: CheckChangePhoneNumberCode
): Ok = exec(f) as Ok
