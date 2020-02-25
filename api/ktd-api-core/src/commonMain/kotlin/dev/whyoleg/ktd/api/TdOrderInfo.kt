package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Order information
 *
 * @property name Name of the user
 * @property phoneNumber Phone number of the user
 * @property emailAddress Email address of the user
 * @property shippingAddress Shipping address for this order
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("orderInfo")
data class TdOrderInfo(
    @SerialName("name")
    val name: String,
    @SerialName("phone_number")
    val phoneNumber: String,
    @SerialName("email_address")
    val emailAddress: String,
    @SerialName("shipping_address")
    val shippingAddress: TdAddress?,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
