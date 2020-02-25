package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns an IETF language tag of the language preferred in the country, which should be used to fill native fields in Telegram Passport personal details
 * Returns a 404 error if unknown
 *
 * @property countryCode A two-letter ISO 3166-1 alpha-2 country code
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getPreferredCountryLanguage(countryCode: String? = null, extra: TdExtra
        = TdExtra.EMPTY): TdText = exec(TdGetPreferredCountryLanguage(countryCode, extra))
