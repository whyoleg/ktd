package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about members or banned users in a supergroup or channel
 * Can be used only if SupergroupFullInfo.can_get_members == true
 * Additionally, administrator privileges may be required for some filters
 *
 * @property supergroupId Identifier of the supergroup or channel
 * @property filter The type of users to return
 *                  By default, supergroupMembersRecent
 * @property offset Number of users to skip
 * @property limit The maximum number of users be returned
 *                 Up to 200
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getSupergroupMembers(
    supergroupId: Int = 0,
    filter: TdSupergroupMembersFilter? = null,
    offset: Int = 0,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdChatMembers = exec(TdGetSupergroupMembers(supergroupId, filter, offset, limit, extra))
