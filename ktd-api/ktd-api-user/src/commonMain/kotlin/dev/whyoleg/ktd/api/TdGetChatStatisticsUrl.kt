package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns an HTTP URL with the chat statistics
 * Currently this method can be used only for channels
 * Can be used only if SupergroupFullInfo.can_view_statistics == true
 *
 * @property chatId Chat identifier
 * @property parameters Parameters from "tg://statsrefresh?params=******" link
 * @property isDark Pass true if a URL with the dark theme must be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getChatStatisticsUrl")
data class TdGetChatStatisticsUrl(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("parameters")
    val parameters: String? = null,
    @SerialName("is_dark")
    val isDark: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdHttpUrl> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetChatStatisticsUrl {
        return copy(extra = extra.copy(id = id))
    }
}
