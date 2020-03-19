package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a tg:// deep link
 * Use "tg://need_update_for_some_feature" or "tg:some_unsupported_feature" for testing
 * Returns a 404 error for unknown links
 * Can be called before authorization
 *
 * @property link The link
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getDeepLinkInfo")
data class TdGetDeepLinkInfo(
    @SerialName("link")
    val link: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdDeepLinkInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetDeepLinkInfo {
        return copy(extra = extra.copy(id = id))
    }
}
