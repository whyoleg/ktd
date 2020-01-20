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
 * Resends phone number confirmation code
 */
suspend fun TelegramClient.resendPhoneNumberConfirmationCode(): AuthenticationCodeInfo = authentication(
    ResendPhoneNumberConfirmationCode()
)

/**
 * Resends phone number confirmation code
 */
suspend fun TelegramClient.authentication(
    f: ResendPhoneNumberConfirmationCode
): AuthenticationCodeInfo = exec(f) as AuthenticationCodeInfo
