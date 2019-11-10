@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.ton

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sends a request to TON lite server through Telegram servers
 *
 * @request - The request
 */
suspend fun TelegramClient.sendTonLiteServerRequest(
    request: ByteArray = byteArrayOf()
): TonLiteServerResponse = ton(
    SendTonLiteServerRequest(
        request
    )
)

/**
 * Returns a salt to be used with locally stored password to access a local TON-based wallet
 */
suspend fun TelegramClient.getTonWalletPasswordSalt(): TonWalletPasswordSalt = ton(
    GetTonWalletPasswordSalt()
)
