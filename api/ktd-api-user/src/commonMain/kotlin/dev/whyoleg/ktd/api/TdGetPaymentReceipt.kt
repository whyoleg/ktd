package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a successful payment
 *
 * @property chatId Chat identifier of the PaymentSuccessful message
 * @property messageId Message identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getPaymentReceipt")
data class TdGetPaymentReceipt(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPaymentReceipt> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetPaymentReceipt {
        return copy(extra = extra.copy(id = id))
    }
}
