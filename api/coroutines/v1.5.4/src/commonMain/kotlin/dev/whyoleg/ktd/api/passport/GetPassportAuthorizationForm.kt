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
 * Returns a Telegram Passport authorization form for sharing data with a service
 *
 * @botUserId - User identifier of the service's bot
 * @scope - Telegram Passport element types requested by the service
 * @publicKey - Service's public_key
 * @nonce - Authorization form nonce provided by the service
 */
suspend fun TelegramClient.getPassportAuthorizationForm(
    botUserId: Int = 0,
    scope: String? = null,
    publicKey: String? = null,
    nonce: String? = null
): PassportAuthorizationForm = passport(
    GetPassportAuthorizationForm(
        botUserId,
        scope,
        publicKey,
        nonce
    )
)

/**
 * Returns a Telegram Passport authorization form for sharing data with a service
 */
suspend fun TelegramClient.passport(
    f: GetPassportAuthorizationForm
): PassportAuthorizationForm = exec(f) as PassportAuthorizationForm
