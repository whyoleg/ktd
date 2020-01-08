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
 * Requests QR code authentication by scanning a QR code on another logged in device
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber
 *
 * @otherUserIds - List of user identifiers of other users currently using the client
 */
suspend fun TelegramClient.requestQrCodeAuthentication(
    otherUserIds: IntArray = intArrayOf()
): Ok = authentication(
    RequestQrCodeAuthentication(
        otherUserIds
    )
)

/**
 * Requests QR code authentication by scanning a QR code on another logged in device
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber
 */
suspend fun TelegramClient.authentication(
    f: RequestQrCodeAuthentication
): Ok = exec(f) as Ok
