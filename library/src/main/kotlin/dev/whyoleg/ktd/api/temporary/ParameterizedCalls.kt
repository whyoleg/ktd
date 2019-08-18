@file:Suppress("unused")

package dev.whyoleg.ktd.api.temporary

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Creates a new temporary password for processing payments
 *
 * @password - Persistent user password
 * @validFor - Time during which the temporary password will be valid, in seconds; should be between 60 and 86400
 */
suspend fun TelegramClient.createTemporaryPassword(
    password: String,
    validFor: Int
): TemporaryPasswordState = temporary(
    CreateTemporaryPassword(
        password,
        validFor
    )
)

/**
 * Returns information about the current temporary password
 */
suspend fun TelegramClient.getTemporaryPasswordState(): TemporaryPasswordState = temporary(
    GetTemporaryPasswordState()
)
