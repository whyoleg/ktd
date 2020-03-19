package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * List of users nearby has changed
 * The update is sent only 60 seconds after a successful searchChatsNearby request
 *
 * @property usersNearby The new list of users nearby
 */
@Serializable
@SerialName("updateUsersNearby")
data class TdUpdateUsersNearby(
    @SerialName("users_nearby")
    val usersNearby: List<TdChatNearby>
) : TdUpdate
