package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a web page preview by the text of the message
 * Do not call this function too often
 * Returns a 404 error if the web page has no preview
 *
 * @property text Message text with formatting
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getWebPagePreview")
data class TdGetWebPagePreview(
    @SerialName("text")
    val text: TdFormattedText? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdWebPage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetWebPagePreview {
        return copy(extra = extra.copy(id = id))
    }
}
