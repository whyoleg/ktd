@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.passport

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Informs the user that some of the elements in their Telegram Passport contain errors
 * The user will not be able to resend the elements, until the errors are fixed
 *
 * @userId - User identifier
 * @errors - The errors
 */
@BotsOnly
suspend fun TelegramClient.setPassportElementErrors(
    userId: Int = 0,
    errors: Array<InputPassportElementError> = emptyArray()
): Ok = passport(
    SetPassportElementErrors(
        userId,
        errors
    )
)

/**
 * Informs the user that some of the elements in their Telegram Passport contain errors
 * The user will not be able to resend the elements, until the errors are fixed
 */
@BotsOnly
suspend fun TelegramClient.passport(
    f: SetPassportElementErrors
): Ok = exec(f) as Ok
