package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of chat members
 *
 * @property totalCount Approximate total count of chat members found
 * @property members A list of chat members
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("chatMembers")
data class TdChatMembers(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("members")
    val members: List<TdChatMember>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
