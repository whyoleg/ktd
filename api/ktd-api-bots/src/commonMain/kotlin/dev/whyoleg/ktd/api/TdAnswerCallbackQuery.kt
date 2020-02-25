package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sets the result of a callback query
 *
 * @property callbackQueryId Identifier of the callback query
 * @property text Text of the answer
 * @property showAlert If true, an alert should be shown to the user instead of a toast notification
 * @property url URL to be opened
 * @property cacheTime Time during which the result of the query can be cached, in seconds
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("answerCallbackQuery")
data class TdAnswerCallbackQuery(
    @SerialName("callback_query_id")
    val callbackQueryId: Long = 0L,
    @SerialName("text")
    val text: String? = null,
    @SerialName("show_alert")
    val showAlert: Boolean = false,
    @SerialName("url")
    val url: String? = null,
    @SerialName("cache_time")
    val cacheTime: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAnswerCallbackQuery {
        return copy(extra = extra.copy(id = id))
    }
}
