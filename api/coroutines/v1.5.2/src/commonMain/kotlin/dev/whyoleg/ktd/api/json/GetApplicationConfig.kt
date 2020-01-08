@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.json

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns application config, provided by the server
 * Can be called before authorization
 */
suspend fun TelegramClient.getApplicationConfig(): JsonValue = json(
    GetApplicationConfig()
)

/**
 * Returns application config, provided by the server
 * Can be called before authorization
 */
suspend fun TelegramClient.json(
    f: GetApplicationConfig
): JsonValue = exec(f) as JsonValue
