package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a list of chats
 *
 * @property chatIds List of chat identifiers
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("chats")
data class TdChats(
    @SerialName("chat_ids")
    val chatIds: LongArray,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
