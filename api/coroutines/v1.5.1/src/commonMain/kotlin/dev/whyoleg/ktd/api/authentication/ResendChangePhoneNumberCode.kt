@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.authentication

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Re-sends the authentication code sent to confirm a new phone number for the user
 * Works only if the previously received authenticationCodeInfo next_code_type was not null
 */
suspend fun TelegramClient.resendChangePhoneNumberCode(): AuthenticationCodeInfo = authentication(
    ResendChangePhoneNumberCode()
)

/**
 * Re-sends the authentication code sent to confirm a new phone number for the user
 * Works only if the previously received authenticationCodeInfo next_code_type was not null
 */
suspend fun TelegramClient.authentication(
    f: ResendChangePhoneNumberCode
): AuthenticationCodeInfo = exec(f) as AuthenticationCodeInfo
