package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns t.me URLs recently visited by a newly registered user
 *
 * @property referrer Google Play referrer to identify the user
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getRecentlyVisitedTMeUrls")
data class TdGetRecentlyVisitedTMeUrls(
    @SerialName("referrer")
    val referrer: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdTMeUrls> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetRecentlyVisitedTMeUrls {
        return copy(extra = extra.copy(id = id))
    }
}
