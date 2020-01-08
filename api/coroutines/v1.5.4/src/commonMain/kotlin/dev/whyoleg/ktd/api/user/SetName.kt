@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.user

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes the first and last name of the current user
 * If something changes, updateUser will be sent
 *
 * @firstName - The new value of the first name for the user
 * @lastName - The new value of the optional last name for the user
 */
suspend fun TelegramClient.setName(
    firstName: String? = null,
    lastName: String? = null
): Ok = user(
    SetName(
        firstName,
        lastName
    )
)

/**
 * Changes the first and last name of the current user
 * If something changes, updateUser will be sent
 */
suspend fun TelegramClient.user(
    f: SetName
): Ok = exec(f) as Ok
