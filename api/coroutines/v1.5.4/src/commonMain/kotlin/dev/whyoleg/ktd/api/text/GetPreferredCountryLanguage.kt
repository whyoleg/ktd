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
 * Returns an IETF language tag of the language preferred in the country, which should be used to fill native fields in Telegram Passport personal details
 * Returns a 404 error if unknown
 *
 * @countryCode - A two-letter ISO 3166-1 alpha-2 country code
 */
suspend fun TelegramClient.getPreferredCountryLanguage(
    countryCode: String? = null
): Text = text(
    GetPreferredCountryLanguage(
        countryCode
    )
)

/**
 * Returns an IETF language tag of the language preferred in the country, which should be used to fill native fields in Telegram Passport personal details
 * Returns a 404 error if unknown
 */
suspend fun TelegramClient.text(
    f: GetPreferredCountryLanguage
): Text = exec(f) as Text
