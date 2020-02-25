package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Reports some messages from a user in a supergroup as spam
 * Requires administrator rights in the supergroup
 *
 * @property supergroupId Supergroup identifier
 * @property userId User identifier
 * @property messageIds Identifiers of messages sent in the supergroup by the user
 *                      This list must be non-empty
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.reportSupergroupSpam(
    supergroupId: Int = 0,
    userId: Int = 0,
    messageIds: LongArray = longArrayOf(),
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdReportSupergroupSpam(supergroupId, userId, messageIds, extra))
