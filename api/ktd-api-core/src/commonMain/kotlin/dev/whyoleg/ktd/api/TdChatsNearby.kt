package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a list of chats located nearby
 *
 * @property usersNearby List of users nearby
 * @property supergroupsNearby List of location-based supergroups nearby
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("chatsNearby")
data class TdChatsNearby(
    @SerialName("users_nearby")
    val usersNearby: List<TdChatNearby>,
    @SerialName("supergroups_nearby")
    val supergroupsNearby: List<TdChatNearby>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
