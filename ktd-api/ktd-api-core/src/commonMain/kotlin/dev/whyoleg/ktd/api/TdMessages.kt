package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of messages
 *
 * @property totalCount Approximate total count of messages found
 * @property messages List of messages
 *                    Messages may be null
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("messages")
data class TdMessages(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("messages")
    val messages: List<TdMessage>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
