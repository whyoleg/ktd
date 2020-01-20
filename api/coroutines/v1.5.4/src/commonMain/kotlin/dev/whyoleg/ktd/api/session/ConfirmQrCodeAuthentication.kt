@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.session

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Confirms QR code authentication on another device
 * Returns created session on success
 *
 * @link - A link from a QR code
 *         The link must be scanned by the in-app camera
 */
suspend fun TelegramClient.confirmQrCodeAuthentication(
    link: String? = null
): Session = session(
    ConfirmQrCodeAuthentication(
        link
    )
)

/**
 * Confirms QR code authentication on another device
 * Returns created session on success
 */
suspend fun TelegramClient.session(
    f: ConfirmQrCodeAuthentication
): Session = exec(f) as Session
