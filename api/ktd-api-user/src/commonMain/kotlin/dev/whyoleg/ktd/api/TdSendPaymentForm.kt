package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends a filled-out payment form to the bot for final verification
 *
 * @property chatId Chat identifier of the Invoice message
 * @property messageId Message identifier
 * @property orderInfoId Identifier returned by ValidateOrderInfo, or an empty string
 * @property shippingOptionId Identifier of a chosen shipping option, if applicable
 * @property credentials The credentials chosen by user for payment
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendPaymentForm")
data class TdSendPaymentForm(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("order_info_id")
    val orderInfoId: String? = null,
    @SerialName("shipping_option_id")
    val shippingOptionId: String? = null,
    @SerialName("credentials")
    val credentials: TdInputCredentials? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPaymentResult> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendPaymentForm {
        return copy(extra = extra.copy(id = id))
    }
}
