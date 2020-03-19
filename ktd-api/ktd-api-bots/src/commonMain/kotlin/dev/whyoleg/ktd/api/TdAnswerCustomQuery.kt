package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Answers a custom query
 *
 * @property customQueryId Identifier of a custom query
 * @property data JSON-serialized answer to the query
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("answerCustomQuery")
data class TdAnswerCustomQuery(
    @SerialName("custom_query_id")
    val customQueryId: Long = 0L,
    @SerialName("data")
    val data: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAnswerCustomQuery {
        return copy(extra = extra.copy(id = id))
    }
}
