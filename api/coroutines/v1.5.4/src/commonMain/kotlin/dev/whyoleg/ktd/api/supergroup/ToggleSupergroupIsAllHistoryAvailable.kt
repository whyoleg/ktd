@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.supergroup

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Toggles whether the message history of a supergroup is available to new members
 * Requires can_change_info rights
 *
 * @supergroupId - The identifier of the supergroup
 * @isAllHistoryAvailable - The new value of is_all_history_available
 */
suspend fun TelegramClient.toggleSupergroupIsAllHistoryAvailable(
    supergroupId: Int = 0,
    isAllHistoryAvailable: Boolean = false
): Ok = supergroup(
    ToggleSupergroupIsAllHistoryAvailable(
        supergroupId,
        isAllHistoryAvailable
    )
)

/**
 * Toggles whether the message history of a supergroup is available to new members
 * Requires can_change_info rights
 */
suspend fun TelegramClient.supergroup(
    f: ToggleSupergroupIsAllHistoryAvailable
): Ok = exec(f) as Ok
