package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends an inline query to a bot and returns its results
 * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 *
 * @property botUserId The identifier of the target bot
 * @property chatId Identifier of the chat where the query was sent
 * @property userLocation Location of the user, only if needed
 * @property query Text of the query
 * @property offset Offset of the first entry to return
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getInlineQueryResults")
data class TdGetInlineQueryResults(
    @SerialName("bot_user_id")
    val botUserId: Int = 0,
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("user_location")
    val userLocation: TdLocation? = null,
    @SerialName("query")
    val query: String? = null,
    @SerialName("offset")
    val offset: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdInlineQueryResults> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetInlineQueryResults {
        return copy(extra = extra.copy(id = id))
    }
}
