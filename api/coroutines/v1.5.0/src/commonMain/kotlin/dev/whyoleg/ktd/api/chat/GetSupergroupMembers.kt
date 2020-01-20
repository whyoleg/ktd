@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.chat

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about members or banned users in a supergroup or channel
 * Can be used only if SupergroupFullInfo.can_get_members == true
 * Additionally, administrator privileges may be required for some filters
 *
 * @supergroupId - Identifier of the supergroup or channel
 * @filter - The type of users to return
 *           By default, supergroupMembersRecent
 * @offset - Number of users to skip
 * @limit - The maximum number of users be returned
 *          Up to 200
 */
suspend fun TelegramClient.getSupergroupMembers(
    supergroupId: Int = 0,
    filter: SupergroupMembersFilter? = null,
    offset: Int = 0,
    limit: Int = 0
): ChatMembers = chat(
    GetSupergroupMembers(
        supergroupId,
        filter,
        offset,
        limit
    )
)

/**
 * Returns information about members or banned users in a supergroup or channel
 * Can be used only if SupergroupFullInfo.can_get_members == true
 * Additionally, administrator privileges may be required for some filters
 */
suspend fun TelegramClient.chat(
    f: GetSupergroupMembers
): ChatMembers = exec(f) as ChatMembers
