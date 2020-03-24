package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Validates the order information provided by a user and returns the available shipping options for a flexible invoice
 *
 * @property chatId Chat identifier of the Invoice message
 * @property messageId Message identifier
 * @property orderInfo The order information, provided by the user
 * @property allowSave True, if the order information can be saved
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("validateOrderInfo")
data class TdValidateOrderInfo(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("order_info")
    val orderInfo: TdOrderInfo? = null,
    @SerialName("allow_save")
    val allowSave: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdValidatedOrderInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdValidateOrderInfo {
        return copy(extra = extra.copy(id = id))
    }
}
