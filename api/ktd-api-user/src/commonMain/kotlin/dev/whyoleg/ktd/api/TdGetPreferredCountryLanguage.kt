package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns an IETF language tag of the language preferred in the country, which should be used to fill native fields in Telegram Passport personal details
 * Returns a 404 error if unknown
 *
 * @property countryCode A two-letter ISO 3166-1 alpha-2 country code
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getPreferredCountryLanguage")
data class TdGetPreferredCountryLanguage(
    @SerialName("country_code")
    val countryCode: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdText> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetPreferredCountryLanguage {
        return copy(extra = extra.copy(id = id))
    }
}
