package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents the results of the inline query
 * Use sendInlineQueryResultMessage to send the result of the query
 *
 * @property inlineQueryId Unique identifier of the inline query
 * @property nextOffset The offset for the next request
 *                      If empty, there are no more results
 * @property results Results of the query
 * @property switchPmText If non-empty, this text should be shown on the button, which opens a private chat with the bot and sends the bot a start message with the switch_pm_parameter
 * @property switchPmParameter Parameter for the bot start message
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("inlineQueryResults")
data class TdInlineQueryResults(
    @SerialName("inline_query_id")
    val inlineQueryId: Long,
    @SerialName("next_offset")
    val nextOffset: String,
    @SerialName("results")
    val results: List<TdInlineQueryResult>,
    @SerialName("switch_pm_text")
    val switchPmText: String,
    @SerialName("switch_pm_parameter")
    val switchPmParameter: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
