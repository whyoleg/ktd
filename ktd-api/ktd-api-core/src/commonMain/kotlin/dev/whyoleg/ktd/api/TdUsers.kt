package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a list of users
 *
 * @property totalCount Approximate total count of users found
 * @property userIds A list of user identifiers
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("users")
data class TdUsers(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("user_ids")
    val userIds: IntArray,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
