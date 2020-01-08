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
 * Converts a JSON-serialized string to corresponding JsonValue object
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.json(
    f: GetJsonValue
): JsonValue = exec(f) as JsonValue
