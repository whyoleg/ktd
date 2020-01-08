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
 * Reports some messages from a user in a supergroup as spam
 * Requires administrator rights in the supergroup
 *
 * @supergroupId - Supergroup identifier
 * @userId - User identifier
 * @messageIds - Identifiers of messages sent in the supergroup by the user
 *               This list must be non-empty
 */
suspend fun TelegramClient.reportSupergroupSpam(
    supergroupId: Int = 0,
    userId: Int = 0,
    messageIds: LongArray = longArrayOf()
): Ok = supergroup(
    ReportSupergroupSpam(
        supergroupId,
        userId,
        messageIds
    )
)

/**
 * Reports some messages from a user in a supergroup as spam
 * Requires administrator rights in the supergroup
 */
suspend fun TelegramClient.supergroup(
    f: ReportSupergroupSpam
): Ok = exec(f) as Ok
