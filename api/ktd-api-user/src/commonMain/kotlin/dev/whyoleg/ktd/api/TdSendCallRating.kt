package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends a call rating
 *
 * @property callId Call identifier
 * @property rating Call rating
 * @property comment An optional user comment if the rating is less than 5
 * @property problems List of the exact types of problems with the call, specified by the user
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendCallRating")
data class TdSendCallRating(
    @SerialName("call_id")
    val callId: Int = 0,
    @SerialName("rating")
    val rating: Int = 0,
    @SerialName("comment")
    val comment: String? = null,
    @SerialName("problems")
    val problems: List<TdCallProblem> = emptyList(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendCallRating {
        return copy(extra = extra.copy(id = id))
    }
}
