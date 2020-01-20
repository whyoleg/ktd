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
 * Returns the current state of 2-step verification
 */
suspend fun TelegramClient.getPasswordState(): PasswordState = password(
    GetPasswordState()
)

/**
 * Returns the current state of 2-step verification
 */
suspend fun TelegramClient.password(
    f: GetPasswordState
): PasswordState = exec(f) as PasswordState
