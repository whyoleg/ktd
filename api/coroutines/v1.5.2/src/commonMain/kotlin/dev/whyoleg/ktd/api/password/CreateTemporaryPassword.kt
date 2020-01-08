@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.password

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Creates a new temporary password for processing payments
 *
 * @password - Persistent user password
 * @validFor - Time during which the temporary password will be valid, in seconds
 *             Should be between 60 and 86400
 */
suspend fun TelegramClient.createTemporaryPassword(
    password: String? = null,
    validFor: Int = 0
): TemporaryPasswordState = password(
    CreateTemporaryPassword(
        password,
        validFor
    )
)

/**
 * Creates a new temporary password for processing payments
 */
suspend fun TelegramClient.password(
    f: CreateTemporaryPassword
): TemporaryPasswordState = exec(f) as TemporaryPasswordState
