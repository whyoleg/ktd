package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sets the result of a pre-checkout query
 *
 * @property preCheckoutQueryId Identifier of the pre-checkout query
 * @property errorMessage An error message, empty on success
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("answerPreCheckoutQuery")
data class TdAnswerPreCheckoutQuery(
    @SerialName("pre_checkout_query_id")
    val preCheckoutQueryId: Long = 0L,
    @SerialName("error_message")
    val errorMessage: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAnswerPreCheckoutQuery {
        return copy(extra = extra.copy(id = id))
    }
}
