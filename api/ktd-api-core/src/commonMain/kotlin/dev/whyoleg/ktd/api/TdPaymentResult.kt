package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains the result of a payment request
 *
 * @property success True, if the payment request was successful
 *                   Otherwise the verification_url will be not empty
 * @property verificationUrl URL for additional payment credentials verification
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("paymentResult")
data class TdPaymentResult(
    @SerialName("success")
    val success: Boolean,
    @SerialName("verification_url")
    val verificationUrl: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
