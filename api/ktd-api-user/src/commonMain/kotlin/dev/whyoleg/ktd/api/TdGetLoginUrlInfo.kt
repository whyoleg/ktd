package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a button of type inlineKeyboardButtonTypeLoginUrl
 * The method needs to be called when the user presses the button
 *
 * @property chatId Chat identifier of the message with the button
 * @property messageId Message identifier of the message with the button
 * @property buttonId Button identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getLoginUrlInfo")
data class TdGetLoginUrlInfo(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("button_id")
    val buttonId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdLoginUrlInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetLoginUrlInfo {
        return copy(extra = extra.copy(id = id))
    }
}
