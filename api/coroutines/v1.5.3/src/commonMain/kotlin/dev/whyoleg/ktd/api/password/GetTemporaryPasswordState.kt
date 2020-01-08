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
 * Returns information about the current temporary password
 */
suspend fun TelegramClient.getTemporaryPasswordState(): TemporaryPasswordState = password(
    GetTemporaryPasswordState()
)

/**
 * Returns information about the current temporary password
 */
suspend fun TelegramClient.password(
    f: GetTemporaryPasswordState
): TemporaryPasswordState = exec(f) as TemporaryPasswordState
