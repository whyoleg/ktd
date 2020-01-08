@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.text

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
): Text = text(
    GetJsonString(
        jsonValue
    )
)

/**
 * Converts a JsonValue object to corresponding JSON-serialized string
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.text(
    f: GetJsonString
): Text = exec(f) as Text
