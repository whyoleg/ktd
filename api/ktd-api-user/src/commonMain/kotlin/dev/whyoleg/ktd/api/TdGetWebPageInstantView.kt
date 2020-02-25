package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns an instant view version of a web page if available
 * Returns a 404 error if the web page has no instant view page
 *
 * @property url The web page URL
 * @property forceFull If true, the full instant view for the web page will be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getWebPageInstantView")
data class TdGetWebPageInstantView(
    @SerialName("url")
    val url: String? = null,
    @SerialName("force_full")
    val forceFull: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdWebPageInstantView> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetWebPageInstantView {
        return copy(extra = extra.copy(id = id))
    }
}
