package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of users and location-based supergroups nearby
 * The list of users nearby will be updated for 60 seconds after the request by the updates updateUsersNearby
 * The request should be sent again every 25 seconds with adjusted location to not miss new chats
 *
 * @property location Current user location
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchChatsNearby(location: TdLocation? = null, extra: TdExtra =
        TdExtra.EMPTY): TdChatsNearby = exec(TdSearchChatsNearby(location, extra))
