package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns an invoice payment form
 * This method should be called when the user presses inlineKeyboardButtonBuy
 *
 * @property chatId Chat identifier of the Invoice message
 * @property messageId Message identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getPaymentForm")
data class TdGetPaymentForm(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPaymentForm> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetPaymentForm {
        return copy(extra = extra.copy(id = id))
    }
}
