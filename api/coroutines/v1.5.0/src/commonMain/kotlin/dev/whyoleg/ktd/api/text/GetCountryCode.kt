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
 * Uses current user IP to found their country
 * Returns two-letter ISO 3166-1 alpha-2 country code
 * Can be called before authorization
 */
suspend fun TelegramClient.getCountryCode(): Text = text(
    GetCountryCode()
)

/**
 * Uses current user IP to found their country
 * Returns two-letter ISO 3166-1 alpha-2 country code
 * Can be called before authorization
 */
suspend fun TelegramClient.text(
    f: GetCountryCode
): Text = exec(f) as Text
