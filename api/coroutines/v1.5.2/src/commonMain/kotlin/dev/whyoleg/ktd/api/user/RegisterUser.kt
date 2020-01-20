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
 * Finishes user registration
 * Works only when the current authorization state is authorizationStateWaitRegistration
 *
 * @firstName - The first name of the user
 * @lastName - The last name of the user
 */
suspend fun TelegramClient.registerUser(
    firstName: String? = null,
    lastName: String? = null
): Ok = user(
    RegisterUser(
        firstName,
        lastName
    )
)

/**
 * Finishes user registration
 * Works only when the current authorization state is authorizationStateWaitRegistration
 */
suspend fun TelegramClient.user(
    f: RegisterUser
): Ok = exec(f) as Ok
