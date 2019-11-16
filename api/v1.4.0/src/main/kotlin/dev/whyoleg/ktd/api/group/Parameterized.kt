@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.group

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a basic group by its identifier
 * This is an offline request if the current user is not a bot
 *
 * @basicGroupId - Basic group identifier
 */
suspend fun TelegramClient.getBasicGroup(
    basicGroupId: Int = 0
): BasicGroup = group(
    GetBasicGroup(
        basicGroupId
    )
)

/**
 * Returns full information about a basic group by its identifier
 *
 * @basicGroupId - Basic group identifier
 */
suspend fun TelegramClient.getBasicGroupFullInfo(
    basicGroupId: Int = 0
): BasicGroupFullInfo = group(
    GetBasicGroupFullInfo(
        basicGroupId
    )
)

/**
 * Toggles the "All members are admins" setting in basic groups
 * Requires creator privileges in the group
 *
 * @basicGroupId - Identifier of the basic group
 * @everyoneIsAdministrator - New value of everyone_is_administrator
 */
suspend fun TelegramClient.toggleBasicGroupAdministrators(
    basicGroupId: Int = 0,
    everyoneIsAdministrator: Boolean = false
): Ok = group(
    ToggleBasicGroupAdministrators(
        basicGroupId,
        everyoneIsAdministrator
    )
)
