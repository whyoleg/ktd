package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns an HTTP URL which can be used to automatically authorize the user on a website after clicking an inline button of type inlineKeyboardButtonTypeLoginUrl
 * Use the method getLoginUrlInfo to find whether a prior user confirmation is needed
 * If an error is returned, then the button must be handled as an ordinary URL button
 *
 * @property chatId Chat identifier of the message with the button
 * @property messageId Message identifier of the message with the button
 * @property buttonId Button identifier
 * @property allowWriteAccess True, if the user allowed the bot to send them messages
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getLoginUrl")
data class TdGetLoginUrl(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("button_id")
    val buttonId: Int = 0,
    @SerialName("allow_write_access")
    val allowWriteAccess: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdHttpUrl> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetLoginUrl {
        return copy(extra = extra.copy(id = id))
    }
}
