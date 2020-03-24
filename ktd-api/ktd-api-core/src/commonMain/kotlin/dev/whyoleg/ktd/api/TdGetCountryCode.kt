package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Uses current user IP to found their country
 * Returns two-letter ISO 3166-1 alpha-2 country code
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getCountryCode")
data class TdGetCountryCode(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdText> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetCountryCode {
        return copy(extra = extra.copy(id = id))
    }
}
