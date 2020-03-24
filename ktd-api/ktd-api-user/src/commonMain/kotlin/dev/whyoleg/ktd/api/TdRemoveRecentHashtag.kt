package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes a hashtag from the list of recently used hashtags
 *
 * @property hashtag Hashtag to delete
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeRecentHashtag")
data class TdRemoveRecentHashtag(
    @SerialName("hashtag")
    val hashtag: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveRecentHashtag {
        return copy(extra = extra.copy(id = id))
    }
}
