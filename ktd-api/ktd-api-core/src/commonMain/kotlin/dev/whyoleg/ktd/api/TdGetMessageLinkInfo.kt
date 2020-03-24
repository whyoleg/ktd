package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a public or private message link
 *
 * @property url The message link in the format "https://t.me/c/...", or "tg://privatepost?...", or "https://t.me/username/...", or "tg://resolve?..."
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getMessageLinkInfo")
data class TdGetMessageLinkInfo(
    @SerialName("url")
    val url: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessageLinkInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetMessageLinkInfo {
        return copy(extra = extra.copy(id = id))
    }
}
