package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sets the result of an inline query
 *
 * @property inlineQueryId Identifier of the inline query
 * @property isPersonal True, if the result of the query can be cached for the specified user
 * @property results The results of the query
 * @property cacheTime Allowed time to cache the results of the query, in seconds
 * @property nextOffset Offset for the next inline query
 *                      Pass an empty string if there are no more results
 * @property switchPmText If non-empty, this text should be shown on the button that opens a private chat with the bot and sends a start message to the bot with the parameter switch_pm_parameter
 * @property switchPmParameter The parameter for the bot start message
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("answerInlineQuery")
data class TdAnswerInlineQuery(
    @SerialName("inline_query_id")
    val inlineQueryId: Long = 0L,
    @SerialName("is_personal")
    val isPersonal: Boolean = false,
    @SerialName("results")
    val results: List<TdInputInlineQueryResult> = emptyList(),
    @SerialName("cache_time")
    val cacheTime: Int = 0,
    @SerialName("next_offset")
    val nextOffset: String? = null,
    @SerialName("switch_pm_text")
    val switchPmText: String? = null,
    @SerialName("switch_pm_parameter")
    val switchPmParameter: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAnswerInlineQuery {
        return copy(extra = extra.copy(id = id))
    }
}
