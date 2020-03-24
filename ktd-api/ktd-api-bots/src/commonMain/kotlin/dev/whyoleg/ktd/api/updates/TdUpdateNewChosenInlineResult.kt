package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * The user has chosen a result of an inline query
 *
 * @property senderUserId Identifier of the user who sent the query
 * @property userLocation User location, provided by the client
 * @property query Text of the query
 * @property resultId Identifier of the chosen result
 * @property inlineMessageId Identifier of the sent inline message, if known
 */
@Serializable
@SerialName("updateNewChosenInlineResult")
data class TdUpdateNewChosenInlineResult(
    @SerialName("sender_user_id")
    val senderUserId: Int,
    @SerialName("user_location")
    val userLocation: TdLocation?,
    @SerialName("query")
    val query: String,
    @SerialName("result_id")
    val resultId: String,
    @SerialName("inline_message_id")
    val inlineMessageId: String
) : TdUpdate
