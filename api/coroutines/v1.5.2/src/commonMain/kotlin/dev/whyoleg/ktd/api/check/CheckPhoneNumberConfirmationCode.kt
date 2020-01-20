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
 * Checks phone number confirmation code
 *
 * @code - The phone number confirmation code
 */
suspend fun TelegramClient.checkPhoneNumberConfirmationCode(
    code: String? = null
): Ok = check(
    CheckPhoneNumberConfirmationCode(
        code
    )
)

/**
 * Checks phone number confirmation code
 */
suspend fun TelegramClient.check(
    f: CheckPhoneNumberConfirmationCode
): Ok = exec(f) as Ok
