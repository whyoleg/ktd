package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for recently used hashtags by their prefix
 *
 * @property prefix Hashtag prefix to search for
 * @property limit The maximum number of hashtags to be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchHashtags")
data class TdSearchHashtags(
    @SerialName("prefix")
    val prefix: String? = null,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdHashtags> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchHashtags {
        return copy(extra = extra.copy(id = id))
    }
}
