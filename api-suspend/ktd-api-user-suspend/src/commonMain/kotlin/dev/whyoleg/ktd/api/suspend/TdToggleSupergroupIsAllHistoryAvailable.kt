package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Toggles whether the message history of a supergroup is available to new members
 * Requires can_change_info rights
 *
 * @property supergroupId The identifier of the supergroup
 * @property isAllHistoryAvailable The new value of is_all_history_available
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.toggleSupergroupIsAllHistoryAvailable(
    supergroupId: Int = 0,
    isAllHistoryAvailable: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdToggleSupergroupIsAllHistoryAvailable(supergroupId, isAllHistoryAvailable, extra))
