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
 * Deletes a Telegram Passport element
 *
 * @type - Element type
 */
suspend fun TelegramClient.deletePassportElement(
    type: PassportElementType? = null
): Ok = passport(
    DeletePassportElement(
        type
    )
)

/**
 * Deletes a Telegram Passport element
 */
suspend fun TelegramClient.passport(
    f: DeletePassportElement
): Ok = exec(f) as Ok
