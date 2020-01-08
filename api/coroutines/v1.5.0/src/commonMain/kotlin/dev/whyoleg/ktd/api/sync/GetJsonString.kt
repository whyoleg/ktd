@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.sync

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Converts a JsonValue object to corresponding JSON-serialized string
 * This is an offline method
 * Can be called before authorization
 *
 * @jsonValue - The JsonValue object
 */
suspend fun TelegramClient.getJsonString(
    jsonValue: JsonValue? = null
): Text = sync(
    GetJsonString(
        jsonValue
    )
)

/**
 * Converts a JsonValue object to corresponding JSON-serialized string
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.sync(
    f: GetJsonString
): Text = exec(f) as Text
