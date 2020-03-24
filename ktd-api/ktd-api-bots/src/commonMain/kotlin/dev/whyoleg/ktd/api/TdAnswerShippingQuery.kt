package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sets the result of a shipping query
 *
 * @property shippingQueryId Identifier of the shipping query
 * @property shippingOptions Available shipping options
 * @property errorMessage An error message, empty on success
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("answerShippingQuery")
data class TdAnswerShippingQuery(
    @SerialName("shipping_query_id")
    val shippingQueryId: Long = 0L,
    @SerialName("shipping_options")
    val shippingOptions: List<TdShippingOption> = emptyList(),
    @SerialName("error_message")
    val errorMessage: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAnswerShippingQuery {
        return copy(extra = extra.copy(id = id))
    }
}
