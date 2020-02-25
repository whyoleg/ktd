package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a list of users and location-based supergroups nearby
 * The list of users nearby will be updated for 60 seconds after the request by the updates updateUsersNearby
 * The request should be sent again every 25 seconds with adjusted location to not miss new chats
 *
 * @property location Current user location
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchChatsNearby")
data class TdSearchChatsNearby(
    @SerialName("location")
    val location: TdLocation? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChatsNearby> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchChatsNearby {
        return copy(extra = extra.copy(id = id))
    }
}
