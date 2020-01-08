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
 * Returns information about a supergroup or channel by its identifier
 * This is an offline request if the current user is not a bot
 *
 * @supergroupId - Supergroup or channel identifier
 */
suspend fun TelegramClient.getSupergroup(
    supergroupId: Int = 0
): Supergroup = supergroup(
    GetSupergroup(
        supergroupId
    )
)

/**
 * Returns information about a supergroup or channel by its identifier
 * This is an offline request if the current user is not a bot
 */
suspend fun TelegramClient.supergroup(
    f: GetSupergroup
): Supergroup = exec(f) as Supergroup
