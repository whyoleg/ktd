package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a temporary identifier of validated order information, which is stored for one hour
 * Also contains the available shipping options
 *
 * @property orderInfoId Temporary identifier of the order information
 * @property shippingOptions Available shipping options
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("validatedOrderInfo")
data class TdValidatedOrderInfo(
    @SerialName("order_info_id")
    val orderInfoId: String,
    @SerialName("shipping_options")
    val shippingOptions: List<TdShippingOption>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
