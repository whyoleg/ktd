@file:Suppress("unused")

package dev.whyoleg.ktd.api.json

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Converts a JSON-serialized string to corresponding JsonValue object. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.json(
    f: GetJsonValue
): JsonValue = execRaw(f) as JsonValue

/**
 * Returns application config, provided by the server. Can be called before authorization
 */
suspend fun TelegramClient.json(
    f: GetApplicationConfig
): JsonValue = execRaw(f) as JsonValue
