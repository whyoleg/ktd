@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.phone

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Shares a phone number of the current user with a mutual contact
 * Supposed to be called when the user clicks on chatActionBarSharePhoneNumber
 *
 * @userId - Identifier of the user with whom to share the phone number
 *           The user must be a mutual contact
 */
suspend fun TelegramClient.sharePhoneNumber(
    userId: Int = 0
): Ok = phone(
    SharePhoneNumber(
        userId
    )
)

/**
 * Shares a phone number of the current user with a mutual contact
 * Supposed to be called when the user clicks on chatActionBarSharePhoneNumber
 */
suspend fun TelegramClient.phone(
    f: SharePhoneNumber
): Ok = exec(f) as Ok
