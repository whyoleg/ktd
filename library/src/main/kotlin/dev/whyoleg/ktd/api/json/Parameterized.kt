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
 * Converts a JSON-serialized string to corresponding JsonValue object
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @json - The JSON-serialized string
 */
suspend fun TelegramClient.getJsonValue(
    json: String? = null
): JsonValue = json(
    GetJsonValue(
        json
    )
)

/**
 * Returns application config, provided by the server
 * Can be called before authorization
 */
suspend fun TelegramClient.getApplicationConfig(): JsonValue = json(
    GetApplicationConfig()
)
