package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of messages found by a search
 *
 * @property messages List of messages
 * @property nextFromSearchId Value to pass as from_search_id to get more results
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("foundMessages")
data class TdFoundMessages(
    @SerialName("messages")
    val messages: List<TdMessage>,
    @SerialName("next_from_search_id")
    val nextFromSearchId: Long,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
